package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DuplicateZerosTest {

    private final DuplicateZeros.Solution subject = new DuplicateZeros.Solution();

    @Test
    void duplicateZeros() {

        // Given
        int[] input = {1, 0, 2, 3, 0, 4, 5, 0};

        // When
        subject.duplicateZeros(input);

        // Then
        assertThat(input)
                .isEqualTo(new int[]{1, 0, 0, 2, 3, 0, 0, 4});
    }

    @Test
    void duplicateZeros_whenNoZeros_returnSame() {

        // Given
        int[] input = {1, 2, 3};

        // When
        subject.duplicateZeros(input);

        // Then
        assertThat(input)
                .isEqualTo(new int[]{1, 2, 3});
    }

    @Test
    void duplicateZerosAlternative() {

        // Given
        int[] input = {1, 0, 2, 3, 0, 4, 5, 0};

        // When
        subject.duplicateZerosAlternative(input);

        // Then
        assertThat(input)
                .isEqualTo(new int[]{1, 0, 0, 2, 3, 0, 0, 4});
    }

    @Test
    void duplicateZerosAlternative_whenNoZeros_returnSame() {

        // Given
        int[] input = {1, 2, 3};

        // When
        subject.duplicateZerosAlternative(input);

        // Then
        assertThat(input)
                .isEqualTo(new int[]{1, 2, 3});
    }
}