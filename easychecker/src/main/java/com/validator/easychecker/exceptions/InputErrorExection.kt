package com.validator.easychecker.exceptions

import java.security.MessageDigest

class InputErrorExection(var messageText: String) : Exception() {
    override val message: String?
        get() = messageText
}