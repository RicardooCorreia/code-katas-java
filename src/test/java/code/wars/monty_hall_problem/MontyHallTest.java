package code.wars.monty_hall_problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MontyHallTest {

    private final MontyHall subject = new MontyHall();

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                arguments(1, new int[]{3, 3, 2, 3, 3, 2, 2, 3, 2, 2, 1, 1, 1, 1}, 71),
                arguments(2, new int[]{3, 3, 2, 3, 3, 2, 2, 3, 2, 2, 1, 1, 1, 1}, 64),
                arguments(3, new int[]{3, 3, 2, 3, 3, 2, 2, 3, 2, 2, 1, 1, 1, 1}, 64)
        );
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    public void montyHallCase_baseScenarios(
            // Given
            int correctDoor,
            int[] choices,
            int expected) {

        // When
        final int result = subject.montyHallCase(correctDoor, choices);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}
