package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class RemoveDuplicatesFromSortedArrayTest {

    private final RemoveDuplicatesFromSortedArray.Solution subject = new RemoveDuplicatesFromSortedArray.Solution();

    @Test
    void removeDuplicates() {

        // Given
        int[] input = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        // When
        int result = subject.removeDuplicates(input);

        // Then
        assertThat(result)
                .isEqualTo(5);
        assertThat(Arrays.copyOfRange(input, 0, 5))
                .containsExactly(0, 1, 2, 3, 4);
    }

    @Test
    void removeDuplicates_smallArray() {

        // Given
        int[] input = {1, 1, 2};

        // When
        int result = subject.removeDuplicates(input);

        // Then
        assertThat(result)
                .isEqualTo(2);
        assertThat(Arrays.copyOfRange(input, 0, 2))
                .containsExactly(1, 2);
    }

    @Test
    void removeDuplicates_negativeNumbers() {

        // Given
        int[] input = {-3, -1, 0, 0, 0, 3, 3};

        // When
        int result = subject.removeDuplicates(input);

        // Then
        assertThat(result)
                .isEqualTo(4);
        assertThat(Arrays.copyOfRange(input, 0, 4))
                .containsExactly(-3, -1, 0, 3);
    }
}