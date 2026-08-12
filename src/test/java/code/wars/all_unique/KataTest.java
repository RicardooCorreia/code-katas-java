package code.wars.all_unique;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static code.wars.all_unique.Kata.hasUniqueChars;
import static org.assertj.core.api.Assertions.assertThat;

class KataTest {

    @Nested
    class PositiveTests {

        @ParameterizedTest
        @ValueSource(strings = {"abcde", "AaBbc"})
        void should_returnTrue_when_allCharsAreUnique(
            // given
            String input) {

            // when
            boolean result = hasUniqueChars(input);

            // then
            assertThat(result).isTrue();
        }
    }

    @Nested
    class NegativeTests {

        @ParameterizedTest
        @ValueSource(strings = {"  nAa", "++-"})
        void should_returnFalse_when_charsAreNotUnique(
            // given
            String input) {

            // when
            boolean result = hasUniqueChars(input);

            // then
            assertThat(result).isFalse();
        }
    }
}
