package code.wars.positions_average;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PositionAverageTest {

    public static final double TOLERANCE = 1e-9;

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                arguments("466960, 069060, 494940, 060069, 060090, 640009, 496464, 606900, 004000, 944096", 26.6666666667),
                arguments("444996, 699990, 666690, 096904, 600644, 640646, 606469, 409694, 666094, 606490", 29.2592592593),
                arguments("4444444, 4444444, 4444444, 4444444, 4444444, 4444444, 4444444, 4444444", 100),
                arguments("0, 0, 0, 0, 0, 0, 0, 0", 100)
        );
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    void posAverage_baseScenarios(
            // Given
            String input,
            double expected) {

        // When
        final double result = PositionAverage.posAverage(input);

        // Then
        assertThat(Math.abs(result - expected))
                .isLessThanOrEqualTo(TOLERANCE);
    }
}
