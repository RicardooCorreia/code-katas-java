package code.wars.high_and_low;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class KataTest {

    @Test
    public void highAndLow_whenHasMultipleNumbersAndNegatives_returnCorrect() {

        // Given
        final String input = "8 3 -5 42 -1 0 0 -9 4 7 4 -4";

        // When
        final String result = Kata.highAndLow(input);

        // Then
        assertThat(result)
                .isEqualTo("42 -9");
    }

    @Test
    public void highAndLow_whenHasFewNumbers_returnCorrect() {

        // Given
        final String input = "1 2 3";

        // When
        final String result = Kata.highAndLow(input);

        // Then
        assertThat(result)
                .isEqualTo("3 1");
    }

    @Test
    public void highAndLow_whenIsTheSame_returnCorrect() {

        // Given
        final String input = "3 3";

        // When
        final String result = Kata.highAndLow(input);

        // Then
        assertThat(result)
                .isEqualTo("3 3");
    }

    @Test
    public void highAndLow_whenIsSingleNumber_returnCorrect() {

        // Given
        final String input = "3";

        // When
        final String result = Kata.highAndLow(input);

        // Then
        assertThat(result)
                .isEqualTo("3 3");
    }
}
