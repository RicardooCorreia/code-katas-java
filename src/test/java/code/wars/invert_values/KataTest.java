package code.wars.invert_values;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KataTest {

    @Test
    public void invert_invertNumbers() {

        // Given
        int[] input = new int[]{-1, 2, -3, 4, -5};

        // When
        final int[] result = Kata.invert(input);

        // Then
        assertThat(result)
                .isEqualTo(new int[]{1, -2, 3, -4, 5});
    }

    @Test
    public void invert__whenEmpty_returnEmpty() {

        // Given
        int[] input = new int[]{};

        // When
        final int[] result = Kata.invert(input);

        // Then
        assertThat(result)
                .isEqualTo(new int[]{});
    }

    @Test
    public void invert__whenZero_returnZero() {

        // Given
        int[] input = new int[]{0};

        // When
        final int[] result = Kata.invert(input);

        // Then
        assertThat(result)
                .isEqualTo(new int[]{0});
    }
}
