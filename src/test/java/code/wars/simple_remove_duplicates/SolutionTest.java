package code.wars.simple_remove_duplicates;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SolutionTest {

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                arguments(new int[]{3, 4, 4, 3, 6, 3}, new int[]{4, 6, 3}),
                arguments(new int[]{1, 2, 1, 2, 1, 2, 3}, new int[]{1, 2, 3}),
                arguments(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4}),
                arguments(new int[]{1, 1, 4, 5, 1, 2, 1}, new int[]{4, 5, 2, 1})
        );
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    public void solve_baseScenarios(
            // Given
            int[] input,
            int[] expected) {

        // When
        int[] result = Solution.solve(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}
