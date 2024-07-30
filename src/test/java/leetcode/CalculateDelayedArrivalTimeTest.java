package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CalculateDelayedArrivalTimeTest {

    private final CalculateDelayedArrivalTime.Solution subject = new CalculateDelayedArrivalTime.Solution();

    public static Stream<Arguments> examples() {
        return Stream.of(
                Arguments.arguments(15, 3, 20),
                Arguments.arguments(13, 11, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void findDelayedArrivalTime(
            // Given
            int arrivalTime,
            int delayedTime,
            int expected) {

        // When
        int result = subject.findDelayedArrivalTime(arrivalTime, delayedTime);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}