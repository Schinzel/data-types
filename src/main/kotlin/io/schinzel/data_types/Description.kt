package io.schinzel.data_types


/**
 * A description of for example a product
 */
class Description(name: String) : AbstractString(
        string = name,
        canBeEmpty = true,
        minLength = 0,
        maxLength = 1000)

