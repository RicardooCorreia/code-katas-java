package code.wars.single_word_pig_latin;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class PigLatinTest {

    @Nested
    class VowelStartTests {

        @ParameterizedTest
        @CsvSource({"egg, eggway", "apple, appleway", "orange, orangeway", "input, inputway", "umbrella, umbrellaway"})
        void should_appendWay_when_wordStartsWithVowel(String input, String expected) {
            // given
            var pigLatin = new PigLatin();

            // when
            var result = pigLatin.translate(input);

            // then
            assertThat(result).isEqualTo(expected);
        }
    }

    @Nested
    class ConsonantStartTests {

        @ParameterizedTest
        @CsvSource({"map, apmay", "spaghetti, aghettispay", "pig, igpay", "latin, atinlay", "hello, ellohay"})
        void should_moveConsonantsToEnd_when_wordStartsWithConsonant(String input, String expected) {
            // given
            var pigLatin = new PigLatin();

            // when
            var result = pigLatin.translate(input);

            // then
            assertThat(result).isEqualTo(expected);
        }
    }

    @Nested
    class NoVowelTests {

        @ParameterizedTest
        @ValueSource(strings = {"rhythm", "myth", "fly", "hmm"})
        void should_appendAy_when_wordHasNoVowels(String input) {
            // given
            var pigLatin = new PigLatin();

            // when
            var result = pigLatin.translate(input);

            // then
            assertThat(result).isEqualTo(input + "ay");
        }
    }

    @Nested
    class CaseInsensitiveTests {

        @ParameterizedTest
        @CsvSource({"MAP, apmay", "Egg, eggway", "Spaghetti, aghettispay", "PIG, igpay"})
        void should_returnLowercase_when_inputHasUppercase(String input, String expected) {
            // given
            var pigLatin = new PigLatin();

            // when
            var result = pigLatin.translate(input);

            // then
            assertThat(result).isEqualTo(expected);
        }
    }

    @Nested
    class InvalidInputTests {

        @ParameterizedTest
        @ValueSource(strings = {"123", "hello world", "café", "spaghetti1", "map!", "", "  "})
        void should_returnNull_when_inputHasNonAlphaCharacters(String input) {
            // given
            var pigLatin = new PigLatin();

            // when
            var result = pigLatin.translate(input);

            // then
            assertThat(result).isNull();
        }
    }
}
