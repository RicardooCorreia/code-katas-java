package code.wars.sum_of_minimums;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class KataTest {

    @ParameterizedTest
    @MethodSource("sampleTestCases")
    void should_returnSumOfMinimums_when_givenArrayOfArrays(int[][] arr, int expected) {
        // given
        // arr and expected from MethodSource

        // when
        int result = Kata.sumOfMinimums(arr);

        // then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> sampleTestCases() {
        return Stream.of(
                Arguments.of(new int[][]{{7, 9, 8, 6, 2}, {6, 3, 5, 4, 3}, {5, 8, 7, 4, 5}}, 9),
                Arguments.of(new int[][]{{11, 12, 14, 54}, {67, 89, 90, 56}, {7, 9, 4, 3}, {9, 8, 6, 7}}, 76)
        );
    }
}