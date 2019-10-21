package com.validator.easychecker.exceptions

import java.lang.Exception

class DeveloperErrorException(var messageText: String) : Exception() {
    override val message: String?
        get() = messageText
}