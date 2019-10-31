package com.validator.easy_checker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.validator.easychecker.EasyChecker
import com.validator.easychecker.exceptions.DeveloperErrorException
import com.validator.easychecker.exceptions.InputErrorException
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_testEditText.setOnClickListener {
            try {
             var isValidationSuccess =  EasyChecker.validateInput(
                    this,
                    2,
                    firstEditText,
                    secondEditText,
                    thirdEditText,
                    fourthEditText
                )
            } catch (developerErrorException: DeveloperErrorException) {
                //best approach to print in log
                developerErrorException.printStackTrace()
            } catch (inputErrorException: InputErrorException) {
                //best approach is show this to user
                Toast.makeText(
                    this,
                    inputErrorException.message,
                    Toast.LENGTH_LONG
                ).show()
            }

        }


    }

    private fun saveData() {
        Toast.makeText(
            this,
            "dataSaved",
            Toast.LENGTH_SHORT
        ).show()
    }
}
