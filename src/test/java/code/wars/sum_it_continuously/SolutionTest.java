package code.wars.sum_it_continuously;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Nested
    class BasicTests {

        @ParameterizedTest
        @MethodSource("basicInputs")
        void should_returnCumulativeSums_when_givenBasicInput(List<Integer> input, List<Integer> expected) {
            // given
            // input from MethodSource

            // when
            var actual = Solution.add(input);

            // then
            assertThat(actual).isEqualTo(expected);
        }

        private static Stream<Arguments> basicInputs() {
            return Stream.of(
                    Arguments.of(List.of(1, 2, 3, 4, 5), List.of(1, 3, 6, 10, 15)),
                    Arguments.of(List.of(2, 4, 6, 8, 10), List.of(2, 6, 12, 20, 30)),
                    Arguments.of(List.of(1, 8, 27, 64, 125), List.of(1, 9, 36, 100, 225)),
                    Arguments.of(List.of(1, 4, 9, 16, 25, 36), List.of(1, 5, 14, 30, 55, 91)),
                    Arguments.of(List.of(20, 21, 22, 23, 24, 25), List.of(20, 41, 63, 86, 110, 135))
            );
        }
    }

    @Nested
    class LargerTests {

        @ParameterizedTest
        @MethodSource("largerInputs")
        void should_returnCumulativeSums_when_givenLargerInput(List<Integer> input, List<Integer> expected) {
            // given
            // input from MethodSource

            // when
            var actual = Solution.add(input);

            // then
            assertThat(actual).isEqualTo(expected);
        }

        private static Stream<Arguments> largerInputs() {
            return Stream.of(
                    Arguments.of(List.of(9, 18, 27, 36, 45, 54), List.of(9, 27, 54, 90, 135, 189)),
                    Arguments.of(List.of(6, 12, 18, 24, 30, 36, 42), List.of(6, 18, 36, 60, 90, 126, 168)),
                    Arguments.of(List.of(5, 10, 15, 20, 25, 30, 35, 40), List.of(5, 15, 30, 50, 75, 105, 140, 180)),
                    Arguments.of(List.of(7, 14, 21, 28, 35, 42, 49, 56), List.of(7, 21, 42, 70, 105, 147, 196, 252)),
                    Arguments.of(List.of(8, 16, 24, 32, 40, 48, 56, 64), List.of(8, 24, 48, 80, 120, 168, 224, 288))
            );
        }
    }

    @Nested
    class EdgeTests {

        @ParameterizedTest
        @MethodSource("edgeInputs")
        void should_returnCumulativeSums_when_givenEdgeInput(List<Integer> input, List<Integer> expected) {
            // given
            // input from MethodSource

            // when
            var actual = Solution.add(input);

            // then
            assertThat(actual).isEqualTo(expected);
        }

        private static Stream<Arguments> edgeInputs() {
            return Stream.of(
                    Arguments.of(List.of(0), List.of(0)),
                    Arguments.of(List.of(-33), List.of(-33)),
                    Arguments.of(List.of(1, 2), List.of(1, 3)),
                    Arguments.of(List.of(0, 0, 0, 0), List.of(0, 0, 0, 0)),
                    Arguments.of(List.of(0, 3, 0, 0), List.of(0, 3, 3, 3)),
                    Arguments.of(List.of(0, 0, 0, 3), List.of(0, 0, 0, 3)),
                    Arguments.of(List.of(32, -9, 2, 0), List.of(32, 23, 25, 25))
            );
        }
    }
}