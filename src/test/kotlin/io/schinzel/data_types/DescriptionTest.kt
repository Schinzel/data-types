package io.schinzel.data_types

import org.assertj.core.api.Assertions.assertThatCode
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.Test

class DescriptionTest {

    @Test
    fun `constructor | empty | no exception`() {
        assertThatCode { Description("") }
                .doesNotThrowAnyException()
    }

    @Test
    fun `constructor | too long | exception`() {
        assertThatThrownBy { Description("a".repeat(1001)) }
                .isExactlyInstanceOf(Exception::class.java)
                .hasMessageContaining(AbstractString.TOO_LONG)
    }

    @Test
    fun `constructor | control chars | exception`() {
        assertThatThrownBy { Description("<br>") }
                .isExactlyInstanceOf(Exception::class.java)
                .hasMessageContaining(AbstractString.CONTAINS_FORBIDDEN_CHARS)
    }

}