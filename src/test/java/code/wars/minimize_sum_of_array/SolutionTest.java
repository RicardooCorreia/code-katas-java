package code.wars.minimize_sum_of_array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SolutionTest {

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                arguments(new int[]{5, 4, 2, 3}, 22),
                arguments(new int[]{12, 6, 10, 26, 3, 24}, 342),
                arguments(new int[]{9, 2, 8, 7, 5, 4, 0, 6}, 74));
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    public void minSum_returnMinimumSum(
            // Given
            int[] input,
            int expected) {

        // When
        final int result = Solution.minSum(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}
