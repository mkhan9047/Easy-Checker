package com.validator.easychecker

import android.content.Context
import android.util.Patterns
import android.widget.EditText
import com.validator.easychecker.exceptions.InputErrorExection

class EasyChecker {
    companion object {
        /**
         *@author Al. Mujahid Khan
         * need to change the list with varargs
         * needs to throw exception
         * This method validate the input fields, check if the input field is empty and also check for the email
         * @return Boolean with the status of if the fields are validate ok or not
         */
        fun validateInput(
            context: Context,
            passLength: Int,
            vararg inputFields: EditText
        ): Boolean {
            var count = 0
            var isHaveConfirmPassword = false
            for (x in inputFields.indices) {
                if (inputFields[x].text.toString().isEmpty()) {
                    throw InputErrorExection(
                        inputFields[x].tag.toString() + " " +
                                context.resources.getString(R.string.empty)
                    )
                    break
                } else {
                    //check if email is valid
                    if (inputFields[x].tag.toString().contains("Email")) {
                        if (Patterns.EMAIL_ADDRESS.matcher(inputFields[x].text.toString().trim()).matches()) {
                            count++
                        } else {
                            throw InputErrorExection(
                                inputFields[x].tag.toString() + " " +
                                        context.resources.getString(R.string.invalid)
                            )
                            break
                        }
                    } else if (inputFields[x].tag.toString().contains("Phone")) {
                        if (Patterns.PHONE.matcher(inputFields[x].text.toString().trim()).matches()) {
                            count++
                        } else {
                            throw InputErrorExection(
                                inputFields[x].tag.toString() + " " +
                                        context.resources.getString(R.string.invalid)
                            )
                            break
                        }
                    } else {
                        //check if the password and confirm password is same
                        if (inputFields[x].tag.toString() == "Password") {
                            if (inputFields[x].text.length >= passLength) {
                                for (y in inputFields.indices) {
                                    if (inputFields[y].tag.toString().contains("Confirm")) {
                                        isHaveConfirmPassword = true
                                        if (inputFields[y].text.toString() !=
                                            inputFields[x].text.toString()
                                        ) {
                                            throw InputErrorExection(
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
                                throw InputErrorExection(
                                    String.format(
                                        "Password can't be less than %d",
                                        passLength
                                    )
                                )
                            }
                        } else {
                            count++
                        }
                    }
                }
            }
            return count == inputFields.size

        }
    }
}
