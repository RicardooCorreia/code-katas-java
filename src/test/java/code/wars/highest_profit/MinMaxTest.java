package code.wars.highest_profit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MinMaxTest {

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                arguments(new int[]{1, 2, 3, 4, 5}, new int[]{1, 5}),
                arguments(new int[]{2334454, 5}, new int[]{5, 2334454}),
                arguments(new int[]{1}, new int[]{1, 1}));
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    public void minMax_baseTests(
            // Given
            int[] input,
            int[] expected) {

        // When
        final int[] result = MinMax.minMax(input);

        // Then
        assertThat(result)
                .containsExactly(expected);
    }
}
