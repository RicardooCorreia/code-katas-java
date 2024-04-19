package code.wars.staton_measure;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KataTest {

    @Test
    public void stantonMeasure() {

        // Given
        final int[] input = {1, 4, 3, 2, 1, 2, 3, 2};

        // When
        final int result = Kata.stantonMeasure(input);

        // Then
        assertThat(result).isEqualTo(3);
    }
}
