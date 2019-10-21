package com.validator.easychecker.util

class Util {
    companion object{
         fun getNumberSuffix(number: Int): String {
            if (number in 11..13) {
                return "th"
            }
            return when (number % 10) {
                1 -> "st"
                2 -> "nd"
                3 -> "rd"
                else -> "th"
            }
        }
    }
}