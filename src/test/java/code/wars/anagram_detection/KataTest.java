package code.wars.anagram_detection;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class KataTest {

    @Nested
    class PositiveTests {

        @ParameterizedTest
        @CsvSource({
                "'', ''",
                "foefet, toffee",
                "Buckethead, DeathCubeK",
                "Twoo, Woot"
        })
        void should_returnTrue_when_stringsAreAnagrams(String a, String b) {
            // given - inputs from CsvSource

            // when
            boolean actual = Kata.isAnagram(a, b);

            // then
            assertThat(actual).isTrue();
        }
    }

    @Nested
    class NegativeTests {

        @ParameterizedTest
        @CsvSource({
                "ab, cdcd",
                "ac, bb",
                "aab, abb",
                "a, aaa",
                "dumble, bumble",
                "ound, round",
                "apple, pale"
        })
        void should_returnFalse_when_stringsAreNotAnagrams(String a, String b) {
            // given - inputs from CsvSource

            // when
            boolean actual = Kata.isAnagram(a, b);

            // then
            assertThat(actual).isFalse();
        }
    }
}