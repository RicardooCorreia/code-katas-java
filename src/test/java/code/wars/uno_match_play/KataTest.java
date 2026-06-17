package code.wars.uno_match_play;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class KataTest {

    @Nested
    class PositiveTests {
        @ParameterizedTest
        @MethodSource("canPlayCases")
        void should_returnTrue_when_handHasMatchingCard(String[] hand, String card) {
            // given
            // hand and card from MethodSource

            // when
            boolean result = Kata.canPlay(hand, card);

            // then
            assertThat(result).isTrue();
        }

        private static Stream<Arguments> canPlayCases() {
            return Stream.of(
                    Arguments.of(new String[]{"yellow 3", "yellow 5", "red 8"}, "red 2"),
                    Arguments.of(new String[]{"yellow 3", "yellow 5", "red 8"}, "blue 5"),
                    Arguments.of(new String[]{"yellow 5", "yellow 8", "red 0", "blue 0", "green 4"}, "green 2"),
                    Arguments.of(new String[]{"red 2"}, "red 0")
            );
        }
    }

    @Nested
    class NegativeTests {
        @ParameterizedTest
        @MethodSource("cannotPlayCases")
        void should_returnFalse_when_handHasNoMatchingCard(String[] hand, String card) {
            // given
            // hand and card from MethodSource

            // when
            boolean result = Kata.canPlay(hand, card);

            // then
            assertThat(result).isFalse();
        }

        private static Stream<Arguments> cannotPlayCases() {
            return Stream.of(
                    Arguments.of(new String[]{"yellow 3", "blue 5", "red 8", "red 9"}, "green 4"),
                    Arguments.of(new String[]{"yellow 3", "red 8"}, "green 2"),
                    Arguments.of(new String[]{}, "green 2"),
                    Arguments.of(new String[]{"red 2", "red 8", "red 5"}, "blue 1")
            );
        }
    }
}
