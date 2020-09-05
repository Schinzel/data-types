package io.schinzel.data_types

/**
 * For a first or last name
 */
class Name(name: String) : AbstractString(
        string = name,
        canBeEmpty = false,
        minLength = 2,
        maxLength = 100,
        forbiddenCharacters = forbiddenChars
) {
    companion object {
        private val forbiddenChars = "<>';:&|()/\\=@!".toCharArray().map { "$it" } +
                (1..9).map { "$it" }
    }
}
