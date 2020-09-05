package io.schinzel.data_types

import java.util.regex.Pattern

class MobileNumber(val number: String) {
    init {
        try {
            if (number.isEmpty())
                err("Mobile number cannot be empty")
            val formattedNumber = format(number)
            if (!hasOnlyValidChars(formattedNumber))
                err("Invalid chars in mobile number.")
            if (!isValid(number))
                err("Invalid mobile number.")
        } catch (e: Exception) {
            err("Problems with mobile number '$number'. ${e.message}")
        }
    }


    companion object {
        private val VALID_MOBILE_NUMBER_REGEX: Pattern = Pattern
                .compile("^[+]*[(]?[0-9]{1,4}[)]?[-\\s./0-9]*\$")

        private val VALID_CHARS_IN_MOBILE_NUMBER_REGEX: Pattern = Pattern.compile("^[*+\\-0-9 ]+\$")

        internal fun isValid(number: String): Boolean = VALID_MOBILE_NUMBER_REGEX.matcher(number).find()

        internal fun hasOnlyValidChars(number: String): Boolean = VALID_CHARS_IN_MOBILE_NUMBER_REGEX.matcher(number).find()


        internal fun format(number: String): String {
            // remove chars -, space, (, ) and plus
            val formattedNumber = number
                    .replace("-", "")
                    .replace(" ", "")
                    .replace("(", "")
                    .replace(")", "")
                    .replace("+", "")
            return when {
                // Remove any staring 00
                formattedNumber.startsWith("00") -> formattedNumber.replaceFirst("00", "")
                else -> formattedNumber
            }
        }
    }
}