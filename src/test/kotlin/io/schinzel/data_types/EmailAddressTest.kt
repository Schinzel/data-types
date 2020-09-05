package io.schinzel.data_types

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.Test

internal class EmailAddressTest {

    @Test
    fun `isValid | valid address | true`() {
        val actual = EmailAddress.isValid("name@example.com")
        assertThat(actual).isTrue
    }

    @Test
    fun `isValid | invalid address | false`() {
        val actual = EmailAddress.isValid("example.com")
        assertThat(actual).isFalse
    }


    @Test
    fun `isValid | invalid address 2 | false`() {
        val actual = EmailAddress.isValid("name@examplecom")
        assertThat(actual).isFalse
    }

    @Test
    fun `address | a valid email address | is argument address`() {
        val actual = EmailAddress("name@example.com").address
        assertThat(actual).isEqualTo("name@example.com")
    }

    @Test
    fun `constructor | invalid email address | exception`() {
        assertThatThrownBy { EmailAddress("example.com") }
                .isExactlyInstanceOf(Exception::class.java)
    }


}