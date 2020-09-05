package io.schinzel.data_types

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.Test

class MobileNumberTest {

    @Test
    fun `hasOnlyValidChars | only valid chars | true`() {
        val actual = MobileNumber.hasOnlyValidChars("0733112233")
        assertThat(actual).isTrue
    }

    @Test
    fun `hasOnlyValidChars | has slash | false`() {
        val actual = MobileNumber.hasOnlyValidChars("0733/112233")
        assertThat(actual).isFalse
    }

    @Test
    fun `isValid | valid mobile number | true`() {
        val actual = MobileNumber.isValid("460733112233")
        assertThat(actual).isTrue
    }

    @Test
    fun `format | correctly formatted number | unchanged`() {
        val actual = MobileNumber.format("460733112233")
        assertThat(actual).isEqualTo("460733112233")
    }

    @Test
    fun `format | several chars that should be removed | number with chars removed`() {
        val actual = MobileNumber.format("+(46)-0733112233")
        assertThat(actual).isEqualTo("460733112233")
    }

    @Test
    fun `constructor | invalid mobile number | exception `() {
        assertThatThrownBy { MobileNumber("non valid number") }
                .isExactlyInstanceOf(Exception::class.java)
    }

    @Test
    fun `constructor | empty mobile number | exception `() {
        assertThatThrownBy { MobileNumber("") }
                .isExactlyInstanceOf(Exception::class.java)
    }

    @Test
    fun `number | valid number | is same as in constructor`() {
        val validWellFormattedNumber = "460733112233"
        val actual = MobileNumber(validWellFormattedNumber).number
        assertThat(actual).isEqualTo(validWellFormattedNumber)
    }

}