package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LongestStrictlyIncreasingOrStrictlyDecreasingSubarrayTest {

    private final LongestStrictlyIncreasingOrStrictlyDecreasingSubarray.Solution subject = new LongestStrictlyIncreasingOrStrictlyDecreasingSubarray.Solution();

    @Test
    void longestMonotonicSubarray_whenMixed_returnCount() {

        // Given
        int[] input = {1, 4, 3, 3, 2};

        // When
        int result = subject.longestMonotonicSubarray(input);

        // Then
        assertThat(result)
                .isEqualTo(2);
    }

    @Test
    void longestMonotonicSubarray_whenSingleNumber_returnReturn1() {

        // Given
        int[] input = {3, 3, 3, 3, 3};

        // When
        int result = subject.longestMonotonicSubarray(input);

        // Then
        assertThat(result)
                .isEqualTo(1);
    }

    @Test
    void longestMonotonicSubarray_whenDecreasing_returnReturnCount() {

        // Given
        int[] input = {3, 2, 1};

        // When
        int result = subject.longestMonotonicSubarray(input);

        // Then
        assertThat(result)
                .isEqualTo(3);
    }

    @Test
    void longestMonotonicSubarray_mixedExample_returnReturnCount() {

        // Given
        int[] input = {1, 9, 7, 1};

        // When
        int result = subject.longestMonotonicSubarray(input);

        // Then
        assertThat(result)
                .isEqualTo(3);
    }

    @Test
    void longestMonotonicSubarray_mixedExample2_returnReturnCount() {

        // Given
        int[] input = {1,5,2,7};

        // When
        int result = subject.longestMonotonicSubarray(input);

        // Then
        assertThat(result)
                .isEqualTo(2);
    }
}