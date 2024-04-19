package code.wars.square_every_digit;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SquareDigitTest {

    private final SquareDigit subject = new SquareDigit();

    @Test
    void squareDigits_squaresEveryDigit() {

        // Given
        final int input = 9119;

        // When
        final int result = subject.squareDigits(input);

        // Then
        assertThat(result)
                .isEqualTo(Integer.valueOf("81" + "1" + "1" + "81"));
    }

    @Test
    void squareDigits_whenZero_returns0() {

        // Given
        final int input = 0;

        // When
        final int result = subject.squareDigits(input);

        // Then
        assertThat(result)
                .isEqualTo(0);
    }
}