package code.wars.growing_plant;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SimpleFunTest {

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                arguments(100, 10, 910, 10),
                arguments(10, 9, 4, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    public void growingPlant_baseTests(
            // Given
            int upSpeed,
            int downSpeed,
            int desiredHeight,
            int expected) {

        // When
        final int result = SimpleFun.growingPlant(upSpeed, downSpeed, desiredHeight);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}
