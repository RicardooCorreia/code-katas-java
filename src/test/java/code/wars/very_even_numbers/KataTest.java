package code.wars.very_even_numbers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static code.wars.very_even_numbers.Kata.isVeryEvenNumber;
import static org.assertj.core.api.Assertions.assertThat;

class KataTest {

    @Nested
    @DisplayName("positive examples")
    class PositiveExamples {

        @Test
        @DisplayName("0 is very even")
        void zero_is_very_even() {
            // given
            var number = 0;

            // when
            var result = isVeryEvenNumber(number);

            // then
            assertThat(result).isTrue();
        }

        @Test
        @DisplayName("4 is very even")
        void four_is_very_even() {
            // given
            var number = 4;

            // when
            var result = isVeryEvenNumber(number);

            // then
            assertThat(result).isTrue();
        }

        @Test
        @DisplayName("222 is very even")
        void two_hundred_twenty_two_is_very_even() {
            // given
            var number = 222;

            // when
            var result = isVeryEvenNumber(number);

            // then
            assertThat(result).isTrue();
        }

        @Test
        @DisplayName("24 is very even")
        void twenty_four_is_very_even() {
            // given
            var number = 24;

            // when
            var result = isVeryEvenNumber(number);

            // then
            assertThat(result).isTrue();
        }

        @Test
        @DisplayName("400000220 is very even")
        void four_hundred_million_two_hundred_twenty_is_very_even() {
            // given
            var number = 400000220;

            // when
            var result = isVeryEvenNumber(number);

            // then
            assertThat(result).isTrue();
        }
    }

    @Nested
    @DisplayName("negative examples")
    class NegativeExamples {

        @Test
        @DisplayName("12 is not very even")
        void twelve_is_not_very_even() {
            // given
            var number = 12;

            // when
            var result = isVeryEvenNumber(number);

            // then
            assertThat(result).isFalse();
        }

        @Test
        @DisplayName("5 is not very even")
        void five_is_not_very_even() {
            // given
            var number = 5;

            // when
            var result = isVeryEvenNumber(number);

            // then
            assertThat(result).isFalse();
        }

        @Test
        @DisplayName("45 is not very even")
        void forty_five_is_not_very_even() {
            // given
            var number = 45;

            // when
            var result = isVeryEvenNumber(number);

            // then
            assertThat(result).isFalse();
        }

        @Test
        @DisplayName("4554 is not very even")
        void four_thousand_five_hundred_fifty_four_is_not_very_even() {
            // given
            var number = 4554;

            // when
            var result = isVeryEvenNumber(number);

            // then
            assertThat(result).isFalse();
        }

        @Test
        @DisplayName("1234 is not very even")
        void one_thousand_two_hundred_thirty_four_is_not_very_even() {
            // given
            var number = 1234;

            // when
            var result = isVeryEvenNumber(number);

            // then
            assertThat(result).isFalse();
        }

        @Test
        @DisplayName("88 is not very even")
        void eighty_eight_is_not_very_even() {
            // given
            var number = 88;

            // when
            var result = isVeryEvenNumber(number);

            // then
            assertThat(result).isFalse();
        }
    }
}