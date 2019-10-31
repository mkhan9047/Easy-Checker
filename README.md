# Easy-Checker

[![](https://jitpack.io/v/mkhan9047/Easy-Checker.svg)](https://jitpack.io/#mkhan9047/Easy-Checker)
[![](https://img.shields.io/badge/Stability-90%25-brightgreen)](https://img.shields.io/badge/Stability-90%25-brightgreen)
[![](https://img.shields.io/badge/Algorithm%20Used-Brute%20Force-yellow)](https://img.shields.io/badge/Algorithm%20Used-Brute%20Force-yellow)
[![](https://img.shields.io/badge/Used%20Language-Kotlin-lightgrey)](https://img.shields.io/badge/Used%20Language-Kotlin-lightgrey)


Easy-Checker is a very simple input validation library for Android written in Kotlin and easily accessable from Java code as well. You will get many validation way or library. But most of them are not so easy for this simple task, that's why most of time time we go for legacy if else chain to check all the input fields, and we all know how distrubing is that. 

  - Empty input box(Edittext)
  - Phone number validation
  - Email validation
  - Password validation
  - Confirm Password Validation
  - Custom Validator

# New Features!

  - Varargs for easy input of input fields insted of array or list
  - Custom Password validation RegEx
  - Singleton class to get rid of objects and memory-leak
  
  ### Installation

Easy-Checker provides maven based easy installation

##### Step 1:
add this to your root build.gradle file 
```sh
 allprojects {
	repositories {
	maven { url 'https://jitpack.io' }
	}
	}
```
##### Step 2:
add this dependency in your app level build.gradle file
```sh
 implementation 'com.github.mkhan9047:Easy-Checker:1.0.1'
```

### How to use?
The main class is EasyChecker it's a singleton class that have a only one public function, validateInput(), It's super simple process, add tags in your input field, call the function with the possible parameters!

##### Please add  android:tag="your field name" to every input-fields (EditText or TextView), It's super easy, This library will use the tags to throw the actual error message, like "Name can't be empty" or "Email is invalid"!

###### Hint: Constant tags are "Password", "Phone", "Email", "Confirm Password" if you have those fields, don't miss this tags and also don't change tag message, for tohers fileds, you can use whatever you wants!


```xml
   <EditText
        android:id="@+id/firstEditText"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Name"
        android:tag="Name"/>
        
        <EditText
        android:id="@+id/fourthEditText"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Confirm Password"
        android:tag="Confirm Password">
```

### Parameters 
- Context 
- Password length that you wants (Integer, Range 4 to 24 as deafult)
- Password Pattern for validating password with Regex, I have wrote a custom class with some regular patterns, see below Password Pattern section, If you don't want to use Password Pattern then pass null or PasswordPattern.PASSWORD_PATTERN_NONE
- Input fields or TextFields (EditText, TextView) [Pass as much you have one by one It's varargs]

```java
      try {
              var isValidationSuccess = EasyChecker.validateInput(
                    MainActivity.this,
                    8,
                    PasswordPattern.PASSWORD_PATTERN_NONE,
                    firstNameEditText,
                    lastNameEditText,
                    emailEditText,
                    passwordEditText,
                    confrimPasswordEditText
                )
                /**you can either use the returned boolean or just do the implementaiton 
                here as errors are only thrown in exception blocks
                **/
               doSignUp()
                //or
                if(isValidationSuccess){
                    //if validated
                         doSignUp()
                }else{
                    //if not validated
                }
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
```

### Exceptions
There are two types of exceptions one is DeveloperException and another is InputErrorException, Those exceptions are basically checked exceptions, so you must have to catch both the exceptions.
- DeveloperException: Basically this exception is thrown if the developer did any error during implementation of this library like not adding "Tag" in input field or Text field or Giving wrong parameters or else

- InputErrorException: This exception is the main validation error done by user, you can get the actual message from the exception and show it to user, Like if one user didn't put the email field then he would get something like : "Email field can't be empty!" or what ever you like

### Password Patterns
I have worte a class with some popular password pattern Regex, Here are the Constants:
- PasswordPattern.PASSWORD_PATTERN_NONE = Use this if you don't wants to use Regex for password validation
- PasswordPattern.PASSWORD_PATTERN_ONE = Minimum eight characters, at least one letter and one number
- PasswordPattern.PASSWORD_PATTERN_TWO = Minimum eight characters, at least one letter, one number and one special character
- PasswordPattern.PASSWORD_PATTERN_THREE = Minimum eight characters, at least one uppercase letter, one lowercase letter and one number
- PasswordPattern.PASSWORD_PATTERN_THREE = Minimum eight characters, at least one uppercase letter, one lowercase letter, one number and one special character

### Development

Want to contribute? Great!
Make a pull requeset, and do your best, I will marge if it's good for others!

License
----
MIT License
Copyright (c) 2019 Mujahid Khan
Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions: The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

