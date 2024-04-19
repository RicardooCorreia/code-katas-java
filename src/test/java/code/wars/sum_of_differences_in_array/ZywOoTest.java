package code.wars.sum_of_differences_in_array;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ZywOoTest {

    @Test
    public void sumOfDifferences_returnSumOfDifferences() {

        // Given
        final int[] input = {1, 2, 10};

        // When
        final int result = ZywOo.sumOfDifferences(input);

        // Then
        assertThat(result).isEqualTo(9);
    }

    @Test
    public void sumOfDifferences_whenNegative_returnSumOfDifferences() {

        // Given
        final int[] input = {-3, -2, -1};

        // When
        final int result = ZywOo.sumOfDifferences(input);

        // Then
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void sumOfDifferences_whenDifferenceIsZero_returnZero() {

        // Given
        final int[] input = {1, 1, 1, 1, 1};

        // When
        final int result = ZywOo.sumOfDifferences(input);

        // Then
        assertThat(result).isEqualTo(0);
    }
}
