package code.wars.find_the_unique_number;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.data.Offset.offset;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class KataTest {

    private double precision = 0.0000000000001;

    public static Stream<Arguments> testScenarios() {

        return Stream.of(
                arguments(new double[]{0, 1, 0}, 1.0),
                arguments(new double[]{1, 1, 1, 2, 1, 1}, 2.0)
        );
    }

    @ParameterizedTest
    @MethodSource("testScenarios")
    public void findUniq(
            // Given
            double[] input,
            double expected) {

        // When
        final double result = Kata.findUniq(input);

        // Then
        assertThat(result)
                .isCloseTo(expected, offset(precision));
    }

    @Test
    void findUniq_whenVeryLargeArray_returnCorrectNumber() {

        // Given
        final int size = 999999;
        final double[] input = new double[size];
        Arrays.fill(input, 1);
        input[size - 1] = 2;

        // When
        final double result = Kata.findUniq(input);

        // Then
        assertThat(result)
                .isEqualTo(2);
    }
}
