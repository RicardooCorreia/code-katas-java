package code.wars.two_sum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SolutionTest {

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                arguments(new int[]{1, 2, 3}, 4, new int[]{0, 2}),
                arguments(new int[]{1234, 5678, 9012}, 14690, new int[]{1, 2}),
                arguments(new int[]{2, 2, 3}, 4, new int[]{0, 1})
        );
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    public void twoSum_baseTests(
            // Given
            int[] input,
            int target,
            int[] expected) {

        // When
        final int[] result = Solution.twoSum(input, target);

        // Then
        assertThat(result)
                .containsExactly(expected);
    }
}
