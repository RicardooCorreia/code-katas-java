package code.wars.days_between;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class DaysBetweenTest {

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                arguments(1987, 1, 16, 2000, 10, 15, 5021),
                arguments(2005, 10, 27, 2017, 4, 6, 4179),
                arguments(1998, 1, 10, 2008, 7, 8, 3832)
        );
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    public void getDaysAlive_baseTests(
            // Given
            int year1,
            int month1,
            int day1,
            int year2,
            int month2,
            int day2,
            int expected) {

        // When
        long result = DaysBetween.getDaysAlive(year1, month1, day1, year2, month2, day2);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}
