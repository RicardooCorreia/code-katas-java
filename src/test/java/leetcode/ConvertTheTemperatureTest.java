package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ConvertTheTemperatureTest {

    private final ConvertTheTemperature.Solution subject = new ConvertTheTemperature.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments(36.50, new double[]{309.65000, 97.70000}),
                Arguments.arguments(122.11, new double[]{395.26000, 251.79800})
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void convertTemperature(
        // Given
        double input,
        double[] expected) {

        // When
        double[] result = subject.convertTemperature(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}