package io.schinzel.data_types

/**
 * The purpose of this class is to be extended to be for example a first name or a description
 */
abstract class AbstractString protected constructor(
        val string: String,
        protected val canBeEmpty: Boolean,
        protected val minLength: Int,
        protected val maxLength: Int,
        protected val forbiddenCharacters: List<String> = listOf("<", ">", "'", ";", "&", "|")
) {

    init {
        try {
            if (!canBeEmpty && string.isEmpty())
                err(CANNOT_BE_EMPTY)
            if (string.length > maxLength)
                err("$TOO_LONG. Was ${string.length} and max length is $maxLength")
            if (string.length < minLength)
                err("$TOO_SHORT. Was ${string.length} and min length is $minLength")
            if (forbiddenCharacters.any { string.contains(it) })
                err("$CONTAINS_FORBIDDEN_CHARS. Forbidden characters are $forbiddenCharacters")
        } catch (e: Exception) {
            err("Error creating string. String was '$string'. Error: ${e.message}.")
        }
    }

    companion object {
        internal const val CANNOT_BE_EMPTY = "String cannot be empty"
        internal const val TOO_LONG = "String to long"
        internal const val TOO_SHORT = "String to short"
        internal const val CONTAINS_FORBIDDEN_CHARS = "String contains forbidden characters"
    }
}




