package code.wars.filter_the_number;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static code.wars.filter_the_number.Kata.filterString;
import static org.assertj.core.api.Assertions.assertThat;

class KataTest {

    @Nested
    class PositiveTests {

        @ParameterizedTest
        @CsvSource({
                "'123', 123",
                "'a1b2c3', 123",
                "'aa1bb2cc3dd', 123",
                "'1a2b3c', 123",
                "'123abc', 123",
                "'abc123', 123"
        })
        void should_returnDigitsInOrder_when_stringContainsMixedChars(String input, long expected) {
            // given
            // input from @CsvSource

            // when
            var result = filterString(input);

            // then
            assertThat(result).isEqualTo(expected);
        }

        @Test
        void should_returnSingleDigit_when_stringContainsOneDigit() {
            // given
            var input = "a5b";

            // when
            var result = filterString(input);

            // then
            assertThat(result).isEqualTo(5L);
        }

        @Test
        void should_returnNumberWithLeadingZeros_when_digitsContainZeros() {
            // given
            var input = "a0b1c2";

            // when
            var result = filterString(input);

            // then
            assertThat(result).isEqualTo(12L);
        }
    }

    @Nested
    class EdgeTests {

        @Test
        void should_returnZero_when_stringHasOnlyZeroDigits() {
            // given
            var input = "a0b0c0";

            // when
            var result = filterString(input);

            // then
            assertThat(result).isZero();
        }

        @Test
        void should_returnLargeNumber_when_stringContainsManyDigits() {
            // given
            var input = "x1234567890y";

            // when
            var result = filterString(input);

            // then
            assertThat(result).isEqualTo(1234567890L);
        }
    }

    @Nested
    class NoDigitsTests {

        @Test
        void should_returnZero_when_stringContainsNoDigits() {
            // given
            var input = "abcdef";

            // when
            var result = filterString(input);

            // then
            assertThat(result).isZero();
        }

        @Test
        void should_returnZero_when_stringIsEmpty() {
            // given
            var input = "";

            // when
            var result = filterString(input);

            // then
            assertThat(result).isZero();
        }
    }
}