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

        btn_test.setOnClickListener {
            try {
                EasyChecker.validateInput(
                    this,
                    2,
                    first,
                    second,
                    third,
                    fourth
                )
            } catch (developerErrorException: DeveloperErrorException) {
                Toast.makeText(
                    this,
                    developerErrorException.message,
                    Toast.LENGTH_LONG
                ).show()
            } catch (inputErrorException: InputErrorException) {
                Toast.makeText(
                    this,
                    inputErrorException.message,
                    Toast.LENGTH_LONG
                ).show()
            }

        }


    }
}
