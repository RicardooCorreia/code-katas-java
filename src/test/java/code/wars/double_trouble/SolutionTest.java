package code.wars.double_trouble;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static code.wars.double_trouble.Solution.trouble;
import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @ParameterizedTest
    @MethodSource("troubleCases")
    void should_removeAdjacentPairs_when_theySumToTarget(int[] arr, int target, int[] expected) {
        // given
        // input from MethodSource

        // when
        var result = trouble(arr, target);

        // then
        assertThat(result).containsExactly(expected);
    }

    private static Stream<Arguments> troubleCases() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 5, 6, 7, 4, 3}, 7, new int[]{1, 3, 5, 6, 7, 4}),
                Arguments.of(new int[]{4, 1, 1, 1, 4}, 2, new int[]{4, 1, 4}),
                Arguments.of(new int[]{2, 6, 2}, 8, new int[]{2, 2}),
                Arguments.of(new int[]{2, 2, 2, 2, 2, 2}, 4, new int[]{2})
        );
    }
}