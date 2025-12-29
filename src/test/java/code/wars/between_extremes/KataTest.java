package code.wars.between_extremes;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KataTest {

    @Test
    void betweenExtremes_example() {

        // Given
        int[] numbers = {21, 34, 54, 43, 26, 12};

        // When
        int result = Kata.betweenExtremes(numbers);

        // Then
        assertThat(result)
                .isEqualTo(42);
    }
}
