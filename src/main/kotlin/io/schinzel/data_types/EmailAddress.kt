package io.schinzel.data_types

import java.util.regex.Pattern

class EmailAddress(val address: String) {
    init {
        try {
            if (address.isEmpty())
                err("Email address cannot be empty.")
            if (!isValid(address))
                err("Invalid email address.")
        } catch (e: Exception) {
            err("Problems with email address '$address'. ${e.message}")
        }
    }


    companion object {
        private val VALID_EMAIL_ADDRESS_REGEX: Pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE)

        internal fun isValid(address: String): Boolean = VALID_EMAIL_ADDRESS_REGEX.matcher(address).find()
    }

}