package code.wars.the_three_amigos;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DinglemouseTest {

    @ParameterizedTest
    @MethodSource("kataExamplesProvider")
    void should_returnCorrectAmigos_when_calledWithKataExamples(int[] input, int[] expected) {
        // given
        // input from MethodSource

        // when
        int[] result = Dinglemouse.threeAmigos(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> kataExamplesProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 34, 2, 1, 5, 3, 5, 7, 234, 2, 1}, new int[]{5, 3, 5}),
                Arguments.of(new int[]{2, 4, 6, 8, 10, 2, 2, 2, 1, 1, 1, 5, 3}, new int[]{2, 2, 2}),
                Arguments.of(new int[]{2, 4, 5, 3, 6, 3, 1, 56, 7, 6, 3, 12}, new int[]{})
        );
    }

    @Nested
    class PositiveTests {

        @Test
        void should_returnAllThree_when_minimalInputWithSameParity() {
            // given
            int[] input = {1, 3, 5};

            // when
            int[] result = Dinglemouse.threeAmigos(input);

            // then
            assertThat(result).isEqualTo(new int[]{1, 3, 5});
        }

        @Test
        void should_returnSameNumberRepeated_when_allNumbersAreIdentical() {
            // given
            int[] input = {7, 7, 7, 7};

            // when
            int[] result = Dinglemouse.threeAmigos(input);

            // then
            assertThat(result).isEqualTo(new int[]{7, 7, 7});
        }

        @Test
        void should_returnLowestRangeWindow_when_lowestRangeNotFirstWindow() {
            // given
            int[] input = {1, 9, 3, 2, 4, 6};

            // when
            int[] result = Dinglemouse.threeAmigos(input);

            // then
            assertThat(result).isEqualTo(new int[]{2, 4, 6});
        }

        @Test
        void should_returnFirstWindow_when_multipleWindowsHaveSameRange() {
            // given
            int[] input = {1, 3, 5, 7, 9, 11};

            // when
            int[] result = Dinglemouse.threeAmigos(input);

            // then
            assertThat(result).isEqualTo(new int[]{1, 3, 5});
        }

        @Test
        void should_returnCorrectAmigos_when_inputContainsNegativeOddNumbers() {
            // given
            int[] input = {-3, -1, 1};

            // when
            int[] result = Dinglemouse.threeAmigos(input);

            // then
            assertThat(result).isEqualTo(new int[]{-3, -1, 1});
        }

        @Test
        void should_returnZeroRangeWindow_when_intOverflowWouldCauseWrongSelection() {
            // given
            int[] input = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, 0, 2, 4};

            // when
            int[] result = Dinglemouse.threeAmigos(input);

            // then
            assertThat(result).isEqualTo(new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE});
        }

        @Test
        void should_returnLowestRangeWindow_when_rangeExceedsIntegerMaxValue() {
            // given
            int[] input = {Integer.MIN_VALUE, 0, 2, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};

            // when
            int[] result = Dinglemouse.threeAmigos(input);

            // then
            assertThat(result).isEqualTo(new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE});
        }
    }

    @Nested
    class NegativeTests {

        @Test
        void should_returnEmpty_when_minimalInputWithMixedParity() {
            // given
            int[] input = {1, 2, 3};

            // when
            int[] result = Dinglemouse.threeAmigos(input);

            // then
            assertThat(result).isEqualTo(new int[]{});
        }

        @Test
        void should_returnEmpty_when_noThreeAdjacentWithSameParity() {
            // given
            int[] input = {1, 2, 3, 4, 5};

            // when
            int[] result = Dinglemouse.threeAmigos(input);

            // then
            assertThat(result).isEqualTo(new int[]{});
        }
    }
}