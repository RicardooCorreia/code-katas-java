package code.wars.character_count;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CharacterCounterTest {

    @Nested
    class PositiveTests {
        @ParameterizedTest
        @CsvSource({
                "abcabc",
                "Abcabc",
                "AbcCBa",
                "?!?!?!",
                "abc123",
                "abc!abc!"
        })
        void should_returnTrue_when_allCharactersHaveEqualCount(String input) {
            // given
            // input from CsvSource

            // when
            boolean result = CharacterCounter.validateWord(input);

            // then
            assertThat(result).isTrue();
        }
    }

    @Nested
    class NegativeTests {
        @ParameterizedTest
        @CsvSource({
                "AbcabcC",
                "pippi",
                "abcabcd",
                "?abc:abc"
        })
        void should_returnFalse_when_charactersHaveUnequalCount(String input) {
            // given
            // input from CsvSource

            // when
            boolean result = CharacterCounter.validateWord(input);

            // then
            assertThat(result).isFalse();
        }
    }
}
