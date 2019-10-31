package com.validator.easychecker.util

class PasswordPattern {
    companion object PATTERNS{
        public val PASSWORD_PATTERN_NONE: String? = null
        public const val PASSWORD_PATTERN_ONE = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}\$"
        public const val PASSWORD_PATTERN_TWO =
            "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@\$!%*#?&])[A-Za-z\\d@\$!%*#?&]{8,}\$"
        public const val PASSWORD_PATTERN_THREE =
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}\$"
        public const val PASSWORD_PATTERN_FOUR =
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@\$!%*?&])[A-Za-z\\d@\$!%*?&]{8,}\$"
    }
}