package code.wars.common_substrings;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KataTest {

    @Test
    void should_returnTrue_when_stringsShareCommonSubstring() {
        // given
        String s1 = "Something";
        String s2 = "Home";

        // when
        boolean result = Kata.SubstringTest(s1, s2);

        // then
        assertThat(result).isTrue();
    }

    @Test
    void should_returnFalse_when_stringsShareNoCommonSubstring() {
        // given
        String s1 = "Something";
        String s2 = "Fun";

        // when
        boolean result = Kata.SubstringTest(s1, s2);

        // then
        assertThat(result).isFalse();
    }
}
