package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MaxSumOfPairWithEqualSumOfDigitsTest {

    private final MaxSumOfPairWithEqualSumOfDigits.Solution subject = new MaxSumOfPairWithEqualSumOfDigits.Solution();

    @Test
    void maximumSum_validExample() {

        // Given
        int[] input = {18, 43, 36, 13, 7};

        // When
        int result = subject.maximumSum(input);

        // Then
        assertThat(result)
                .isEqualTo(54);
    }

    @Test
    void maximumSum_longExample() {

        // Given
        int[] input = {368, 369, 307, 304, 384, 138, 90, 279, 35, 396, 114, 328, 251, 364, 300, 191, 438, 467, 183};

        // When
        int result = subject.maximumSum(input);

        // Then
        assertThat(result)
                .isEqualTo(835);
    }

    @Test
    void maximumSum_complexExample() {

        // Given
        int[] input = {383, 77, 97, 261, 102, 344, 150, 130, 55, 337, 401, 498, 21, 5};

        // When
        int result = subject.maximumSum(input);

        // Then
        assertThat(result)
                .isEqualTo(460);
    }

    @Test
    void maximumSum_invalidExample() {

        // Given
        int[] input = {10, 12, 19, 14};

        // When
        int result = subject.maximumSum(input);

        // Then
        assertThat(result)
                .isEqualTo(-1);
    }
}