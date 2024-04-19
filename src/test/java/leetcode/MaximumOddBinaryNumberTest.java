package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MaximumOddBinaryNumberTest {

    private final MaximumOddBinaryNumber.Solution subject = new MaximumOddBinaryNumber.Solution();

    @Test
    void maximumOddBinaryNumber_whenHasOnlyOne_thenSetsOneLastPositionForOdd() {

        // Given
        String input = "010";

        // When
        String result = subject.maximumOddBinaryNumber(input);

        // Then
        Assertions.assertThat(result)
                .isEqualTo("001");
    }

    @Test
    void maximumOddBinaryNumber_whenHasMultipleOnes_thenSetsOneLastPositionForOddAndOthersFirsPositionsInString() {

        // Given
        String input = "0101";

        // When
        String result = subject.maximumOddBinaryNumber(input);

        // Then
        Assertions.assertThat(result)
                .isEqualTo("1001");
    }
}