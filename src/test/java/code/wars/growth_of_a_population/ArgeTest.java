package code.wars.growth_of_a_population;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ArgeTest {

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                arguments(1500, 5, 100, 5000, 15),
                arguments(1500000, 2.5, 10000, 2000000, 10),
                arguments(1500000, 0.25, 1000, 2000000, 94)
        );
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    public void nbYear_baseTests(

            // Given
            int p0,
            double percent,
            int aug,
            int p,
            int expected) {

        // When
        final int result = Arge.nbYear(p0, percent, aug, p);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }

    @Test
    void nbYear_whenAlreadyAtTarget_returnZero() {

        // Given
        int p0 = 9000;
        double percent = 0;
        int aug = 0;
        int p = 9000;

        // When
        final int result = Arge.nbYear(p0, percent, aug, p);

        // Then
        assertThat(result)
                .isZero();
    }

    @Test
    void nbYear_whenCannotReachTarget_returnMinusOne() {

        // Given
        int p0 = 9000;
        double percent = 0;
        int aug = -100;
        int p = 9001;

        // When
        final int result = Arge.nbYear(p0, percent, aug, p);

        // Then
        assertThat(result)
                .isEqualTo(-1);
    }
}
