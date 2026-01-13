package code.wars.return_negative;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KataTest {

    @Test
    void makeNegative_whenPositive_returnNegative() {

        // Given
        int input = 5;

        // When
        int result = Kata.makeNegative(input);

        // Then
        assertThat(result)
                .isEqualTo(-5);
    }

    @Test
    void makeNegative_whenNegative_returnNegative() {

        // Given
        int input = -5;

        // When
        int result = Kata.makeNegative(input);

        // Then
        assertThat(result)
                .isEqualTo(-5);
    }
}
