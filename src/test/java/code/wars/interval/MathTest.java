package code.wars.interval;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static code.wars.interval.Math.Interval;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MathTest {

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                arguments(new int[]{1, 2, 3, 4, 5}, "[2,5)", new int[]{2, 3, 4}),
                arguments(new int[]{1, 2, 3, 4, 5}, "[2,5]", new int[]{2, 3, 4, 5}),
                arguments(new int[]{1, 2, 3, 4, 5}, "(2,5]", new int[]{3, 4, 5}),
                arguments(new int[]{1, 2, 3, 4, 5}, "(2,5)", new int[]{3, 4}),
                arguments(new int[]{3, 4, 5}, "(-2,5)", new int[]{3, 4})
        );
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    public void interval_baseScenarios(
            // Given
            int[] numbers,
            String range,
            int[] expected) {

        // When
        int[] result = Interval(numbers, range);

        // Then
        assertThat(result)
                .isEqualTo(expected);


        assertThat(Interval(new int[]{}, "(2,5)")).isEqualTo(new int[]{});
    }

    @Test
    void interval_whenRangeIsEmpty_returnEmpty() {

        // Given
        int[] numbers = {1, 2, 3, 4, 5};
        String range = "";

        // When
        int[] result = Interval(numbers, range);

        // Then
        assertThat(result)
                .isEqualTo(new int[]{});
    }

    @Test
    void interval_whenNumbersIsEmpty_returnEmpty() {

        // Given
        int[] numbers = new int[]{};
        String range = "(2,5)";

        // When
        int[] result = Interval(numbers, range);

        // Then
        assertThat(result)
                .isEqualTo(new int[]{});
    }
}
