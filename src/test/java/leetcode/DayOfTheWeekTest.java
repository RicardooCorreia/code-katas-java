package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class DayOfTheWeekTest {

    private final DayOfTheWeek.Solution subject = new DayOfTheWeek.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments(31, 8, 2019, "Saturday"),
                Arguments.arguments(18, 7, 1999, "Sunday"),
                Arguments.arguments(15, 8, 1993, "Sunday"),
                Arguments.arguments(7, 11, 2024, "Thursday")
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void dayOfTheWeek(
            // Given
            int day,
            int month,
            int year,
            String expected) {

        // When
        String result = subject.dayOfTheWeek(day, month, year);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}