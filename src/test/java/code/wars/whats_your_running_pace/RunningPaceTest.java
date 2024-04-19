package code.wars.whats_your_running_pace;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RunningPaceTest {

    @ParameterizedTest(name = "[{index}] {displayName} [{argumentsWithNames}]")
    @CsvSource({
            "2.51,10:43,4:16",
            "1.0,55:06,55:06",
            "0.2,180:32,902:40",
            "1,3:15,3:15",
            "5,25:00,5:00",
            "15,75:00,5:00",
            "2.51,10:43,4:16",
            "4.99,22:32,4:30",
            "0.2,0:38,3:10",
            "42.195,122:57,2:54"
    })
    void calculate_basic_tests(
            // Given
            String distance,
            String runDuration,
            String expectedPace) {

        // When
        String result = RunningPace.calculate(Double.parseDouble(distance), runDuration);

        // Then
        assertThat(result)
                .isEqualTo(expectedPace);
    }
}
