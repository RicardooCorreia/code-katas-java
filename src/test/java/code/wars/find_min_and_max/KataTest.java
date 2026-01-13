package code.wars.find_min_and_max;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KataTest {

    private final Kata subject = new Kata();

    @Test
    void min_findMin() {

        // Given
        int[] input = {4, 6, 2, 1, 9, 63, -134, 566};

        // When
        int result = subject.min(input);

        // Then
        assertThat(result)
                .isEqualTo(-134);
    }

    @Test
    void max_findMax() {

        // Given
        int[] input = {4, 6, 2, 1, 9, 63, -134, 566};

        // When
        int result = subject.max(input);

        // Then
        assertThat(result)
                .isEqualTo(566);
    }
}
