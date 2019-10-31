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
The main class is EasyChecker it's a singleton class that have a only one public function, validateInput()

##### Please add tags to every input-fields (EditText or TextView), It's super easy


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
- Password length that you wants (Integer)
- Input fields or TextFields (EditText, TextView) [Pass as much you have one by one It's varargs]

```java
      try {
              var isValidationSuccess = EasyChecker.validateInput(
                    MainActivity.this,
                    2,
                    firstNameEditText,
                    lastNameEditText,
                    emailEditText,
                    passwordEditText,
                    confrimPasswordEditText
                )
                /**you can either use the returned boolean or just do the implementaiton 
                here as errors are only thrown in exception blocks
                **/
                saveData() or doSignIn() or doSignUp()
                //or
                if(doSignIn){
                    //if validated
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
### Plugins

Dillinger is currently extended with the following plugins. Instructions on how to use them in your own application are linked below.

| Plugin | README |
| ------ | ------ |
| Dropbox | [plugins/dropbox/README.md][PlDb] |
| GitHub | [plugins/github/README.md][PlGh] |
| Google Drive | [plugins/googledrive/README.md][PlGd] |
| OneDrive | [plugins/onedrive/README.md][PlOd] |
| Medium | [plugins/medium/README.md][PlMe] |
| Google Analytics | [plugins/googleanalytics/README.md][PlGa] |


### Development

Want to contribute? Great!

Dillinger uses Gulp + Webpack for fast developing.
Make a change in your file and instantanously see your updates!

Open your favorite Terminal and run these commands.

First Tab:
```sh
$ node app
```

Second Tab:
```sh
$ gulp watch
```

(optional) Third:
```sh
$ karma test
```
#### Building for source
For production release:
```sh
$ gulp build --prod
```
Generating pre-built zip archives for distribution:
```sh
$ gulp build dist --prod
```
### Docker
Dillinger is very easy to install and deploy in a Docker container.

By default, the Docker will expose port 8080, so change this within the Dockerfile if necessary. When ready, simply use the Dockerfile to build the image.

```sh
cd dillinger
docker build -t joemccann/dillinger:${package.json.version} .
```
This will create the dillinger image and pull in the necessary dependencies. Be sure to swap out `${package.json.version}` with the actual version of Dillinger.

Once done, run the Docker image and map the port to whatever you wish on your host. In this example, we simply map port 8000 of the host to port 8080 of the Docker (or whatever port was exposed in the Dockerfile):

```sh
docker run -d -p 8000:8080 --restart="always" <youruser>/dillinger:${package.json.version}
```

Verify the deployment by navigating to your server address in your preferred browser.

```sh
127.0.0.1:8000
```

#### Kubernetes + Google Cloud

See [KUBERNETES.md](https://github.com/joemccann/dillinger/blob/master/KUBERNETES.md)


### Todos

 - Write MORE Tests
 - Add Night Mode

License
----

MIT


**Free Software, Hell Yeah!**

[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)


   [dill]: <https://github.com/joemccann/dillinger>
   [git-repo-url]: <https://github.com/joemccann/dillinger.git>
   [john gruber]: <http://daringfireball.net>
   [df1]: <http://daringfireball.net/projects/markdown/>
   [markdown-it]: <https://github.com/markdown-it/markdown-it>
   [Ace Editor]: <http://ace.ajax.org>
   [node.js]: <http://nodejs.org>
   [Twitter Bootstrap]: <http://twitter.github.com/bootstrap/>
   [jQuery]: <http://jquery.com>
   [@tjholowaychuk]: <http://twitter.com/tjholowaychuk>
   [express]: <http://expressjs.com>
   [AngularJS]: <http://angularjs.org>
   [Gulp]: <http://gulpjs.com>

   [PlDb]: <https://github.com/joemccann/dillinger/tree/master/plugins/dropbox/README.md>
   [PlGh]: <https://github.com/joemccann/dillinger/tree/master/plugins/github/README.md>
   [PlGd]: <https://github.com/joemccann/dillinger/tree/master/plugins/googledrive/README.md>
   [PlOd]: <https://github.com/joemccann/dillinger/tree/master/plugins/onedrive/README.md>
   [PlMe]: <https://github.com/joemccann/dillinger/tree/master/plugins/medium/README.md>
   [PlGa]: <https://github.com/RahulHP/dillinger/blob/master/plugins/googleanalytics/README.md>
