package code.wars.string_to_time;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TimeUtilsTest {

    @Test
    public void convertTime_baseTests() {

        // Given
        int input = 90061;

        // When
        String result = TimeUtils.convertTime(input);

        // Then
        assertEquals("1 1 1 1", result);
    }

    @Test
    public void convertTime_whenNegative_returnCorrect() {

        // Given
        int input = -90061;

        // When
        String result = TimeUtils.convertTime(input);

        // Then
        assertEquals("-1 -1 -1 -1", result);
    }
}
