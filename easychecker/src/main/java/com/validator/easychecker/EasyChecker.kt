package com.validator.easychecker

import android.content.Context
import android.util.Patterns
import android.widget.EditText
import com.validator.easychecker.exceptions.DeveloperErrorException
import com.validator.easychecker.exceptions.InputErrorException
import com.validator.easychecker.util.Util

class EasyChecker {
    companion object {
        /**
         *@author Al. Mujahid Khan
         * This method validate the input fields, check if the input field is empty and also check for the email
         * @return Boolean with the status of if the fields are validate ok or not
         */
        @Throws(
            InputErrorException::class,
            DeveloperErrorException::class
        )
        fun validateInput(
            context: Context,
            passLength: Int,
            vararg inputFields: EditText
        ): Boolean {
            var count = 0
            var isHaveConfirmPassword = false
            for (x in inputFields.indices) {
                if (checkIfTagNotNull(context, *inputFields)) {
                    if (checkInputField(
                            inputFields[x],
                            context
                        )
                    ) {
                        if (checkIfEmailExist(inputFields[x])) {
                            if (checkEmail(
                                    inputFields[x],
                                    context
                                )
                            ) {
                                count++
                            } else {
                                break
                            }
                        } else {
                            //check phone
                            if (checkIfPhoneExist(inputFields[x])) {
                                if (checkPhone(
                                        inputFields[x],
                                        context
                                    )
                                ) {
                                    count++
                                } else {
                                    break
                                }
                            } else {
                                //check password section
                                //check if the password and confirm password is same
                                if (inputFields[x].tag.toString() == "Password") {
                                    if (inputFields[x].text.length >= passLength) {
                                        for (y in inputFields.indices) {
                                            if (inputFields[y].tag.toString().contains("Confirm")) {
                                                isHaveConfirmPassword = true
                                                if (inputFields[y].text.toString() !=
                                                    inputFields[x].text.toString()
                                                ) {
                                                    throw InputErrorException(
                                                        context.getString(R.string.confirm_password_not_match)
                                                    )
                                                    break
                                                } else {
                                                    count++
                                                }
                                            }
                                        }
                                        if (!isHaveConfirmPassword) {
                                            count++
                                        }
                                    } else {
                                        throw InputErrorException(
                                            String.format(
                                                context.getString(R.string.password_length_error),
                                                passLength
                                            )
                                        )
                                    }
                                } else {
                                    count++
                                }
                            }
                        }

                    } else {
                        break
                    }
                } else {
                    break
                }
            }
            return count == inputFields.size
        }

        private fun checkIfTagNotNull(
            context: Context,
            vararg inputField: EditText
        ): Boolean {
            var count = 0
            for (x in inputField.indices) {
                if (inputField[x].tag != null) {
                    count++
                } else {
                    throw DeveloperErrorException(
                        String.format(
                            context.getString(R.string.missing_tag),
                            x + 1, Util.getNumberSuffix(x + 1)
                        )
                    )
                    break
                }
            }
            return inputField.size == count
        }

        private fun checkIfEmailExist(inputField: EditText): Boolean {
            return inputField.tag.toString().contains("Email")
        }

        private fun checkIfPhoneExist(inputField: EditText): Boolean {
            return inputField.tag.toString().contains("Phone")
        }

        private fun checkEmail(
            inputField: EditText,
            context: Context
        ): Boolean {
            //check if email is valid
            return if (Patterns.EMAIL_ADDRESS.matcher(inputField.text.toString().trim())
                    .matches()
            ) {
                true
            } else {
                throw InputErrorException(
                    inputField.tag.toString() + " " +
                            context.resources.getString(R.string.invalid)
                )
                false
            }
        }

        private fun checkInputField(
            inputField: EditText,
            context: Context
        ): Boolean {
            return if (inputField.text.toString().isEmpty()) {
                throw InputErrorException(
                    inputField.tag.toString() + " " +
                            context.resources.getString(R.string.empty)
                )
                false
            } else {
                true
            }
        }

        private fun checkPhone(
            inputField: EditText,
            context: Context
        ): Boolean {
            //check if email is valid
            return if (Patterns.PHONE.matcher(inputField.text.toString().trim())
                    .matches()
            ) {
                true
            } else {
                throw InputErrorException(
                    inputField.tag.toString() + " " +
                            context.resources.getString(R.string.invalid)
                )
                false
            }
        }

        /*      private fun checkPassword(): Boolean {

              }

              private fun checkConfirmPassword(): Boolean {

              }*/
    }


}
