package code.wars.maximum_subarray_sum;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MaxTest {

    @Test
    void sequence_whenEmpty_returnZero() {

        // Given
        final int[] sequence = new int[0];

        // When
        final int result = Max.sequence(sequence);

        // Then
        assertThat(result)
                .isZero();
    }

    @Test
    void sequence_whenAllNegatives_returnZero() {

        // Given
        final int[] sequence = {-1, -2, -3};

        // When
        final int result = Max.sequence(sequence);

        // Then
        assertThat(result)
                .isZero();
    }

    @Test
    void sequence_whenValid_returnGreatestSum() {

        // Given
        final int[] sequence = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        // When
        final int result = Max.sequence(sequence);

        // Then
        assertThat(result)
                .isEqualTo(6);
    }
}