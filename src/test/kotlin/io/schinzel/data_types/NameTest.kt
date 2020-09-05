package io.schinzel.data_types

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.Test

class NameTest {

    @Test
    fun `constructor | empty | exception`() {
        assertThatThrownBy { Name("") }
                .isExactlyInstanceOf(Exception::class.java)
                .hasMessageContaining(AbstractString.CANNOT_BE_EMPTY)
    }


    @Test
    fun `constructor | too short | exception`() {
        assertThatThrownBy { Name("1") }
                .isExactlyInstanceOf(Exception::class.java)
                .hasMessageContaining(AbstractString.TOO_SHORT)
    }

    @Test
    fun `constructor | too long | exception`() {
        assertThatThrownBy { Name("a".repeat(101)) }
                .isExactlyInstanceOf(Exception::class.java)
                .hasMessageContaining(AbstractString.TOO_LONG)
    }

    @Test
    fun `constructor | numbers | exception`() {
        assertThatThrownBy { Name("1234") }
                .isExactlyInstanceOf(Exception::class.java)
                .hasMessageContaining(AbstractString.CONTAINS_FORBIDDEN_CHARS)
    }

    @Test
    fun `string property | Persian | no exception`() {
        val name = "ا ب پ ت ث ج چ ح خ د ذ ر ز ژ س ش"
        val actual =  Name(name).string
        assertThat(actual).isEqualTo(actual)
    }

    @Test
    fun `string property | Polish | no exception`() {
        val name = "ŻŃś"
        val actual =  Name(name).string
        assertThat(actual).isEqualTo(actual)
    }

    @Test
    fun `string property | Cyrillic Russian | no exception`() {
        val name = "ХхЦцЧчШшЩщЪъЫыЬьЭэЮюЯя"
        val actual =  Name(name).string
        assertThat(actual).isEqualTo(actual)
    }

    @Test
    fun `string property | Japanese Kanji| no exception`() {
        val name = "明行極"
        val actual =  Name(name).string
        assertThat(actual).isEqualTo(actual)
    }

}