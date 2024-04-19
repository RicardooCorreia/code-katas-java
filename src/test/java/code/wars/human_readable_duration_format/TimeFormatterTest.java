package code.wars.human_readable_duration_format;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class TimeFormatterTest {

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                arguments(1, "1 second"),
                arguments(62, "1 minute and 2 seconds"),
                arguments(120, "2 minutes"),
                arguments(3600, "1 hour"),
                arguments(3662, "1 hour, 1 minute and 2 seconds")
        );
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    public void formatDuration_baseTests(
            // Given
            int input,
            String expected) {

        // When
        String result = TimeFormatter.formatDuration(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }

    @Test
    void formatDuration_whenZero_returnEmpty() {

        // Given
        int input = 0;

        // When
        String result = TimeFormatter.formatDuration(input);

        // Then
        assertThat(result)
                .isEqualTo("");
    }

    @Test
    void formatDuration_allPossibleUnits_returnCorrect() {

        // Given
        int input = 112532523;

        // When
        String result = TimeFormatter.formatDuration(input);

        // Then
        assertThat(result)
                .isEqualTo("3 years, 207 days, 11 hours, 2 minutes and 3 seconds");
    }

    @Test
    void formatDuration_justTwoUnitsSpreadApart_returnCorrect() {

        // Given
        int input = 172801;

        // When
        String result = TimeFormatter.formatDuration(input);

        // Then
        assertThat(result)
                .isEqualTo("2 days and 1 second");
    }
}
