package code.wars.arrow_pin_decoder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KataTest {

    @Test
    void decArrowPinCode_whenSequenceWithRightUpRight_returnCorrectPin() {

        // Given
        String input = "1→↑→";

        // When
        int[] result = Kata.decArrowPinCode(input);

        // Then
        assertThat(result).containsExactly(1, 2, 5, 6);
    }

    @Test
    void decArrowPinCode_whenSequenceWithStayAndDown_returnCorrectPin() {

        // Given
        String input = "1*2↓";

        // When
        int[] result = Kata.decArrowPinCode(input);

        // Then
        assertThat(result).containsExactly(1, 1, 1, 0);
    }

    @Test
    void decArrowPinCode_whenSequenceStartingWithZeroAndUp_returnCorrectPin() {

        // Given
        String input = "0*2↑";

        // When
        int[] result = Kata.decArrowPinCode(input);

        // Then
        assertThat(result).containsExactly(0, 0, 0, 1);
    }

    @Test
    void decArrowPinCode_whenSequenceWithMultipleUps_returnCorrectPin() {

        // Given
        String input = "0↑↑↑";

        // When
        int[] result = Kata.decArrowPinCode(input);

        // Then
        assertThat(result).containsExactly(0, 1, 4, 7);
    }

    @Test
    void decArrowPinCode_whenSequenceExceedsGridBounds_returnEmpty() {

        // Given
        String input = "0↑↑↑↑";

        // When
        int[] result = Kata.decArrowPinCode(input);

        // Then
        assertThat(result).isEmpty();
    }

    @Test
    void decArrowPinCode_whenSequenceGoesOutOfBoundsWithRightMove_returnEmpty() {

        // Given
        String input = "8↑*5→";

        // When
        int[] result = Kata.decArrowPinCode(input);

        // Then
        assertThat(result).isEmpty();
    }

    @Test
    void decArrowPinCode_whenSequenceGoesOutOfBoundsWithLeftMove_returnEmpty() {

        // Given
        String input = "0←*2←";

        // When
        int[] result = Kata.decArrowPinCode(input);

        // Then
        assertThat(result).isEmpty();
    }

    @Test
    void decArrowPinCode_failingScenario_returnCorrect() {

        // Given
        String input = "0→→→";

        // When
        int[] result = Kata.decArrowPinCode(input);

        // Then
        assertThat(result).isEmpty();
    }
}
