package leetcode;

import leetcode.NumberDistinctIntegersAfterReverseOperations.Solution;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberDistinctIntegersAfterReverseOperationsTest {

    private final Solution subject = new Solution();

    @Test
    void countDistinctIntegers() {

        // Given
        int[] input = {1, 13, 10, 12, 31};

        // When
        int result = subject.countDistinctIntegers(input);

        // Then
        assertThat(result)
                .isEqualTo(6);
    }

    @Test
    void countDistinctIntegers_whenIsAllTheSame_returnOne() {

        // Given
        int[] input = {2, 2, 2};

        // When
        int result = subject.countDistinctIntegers(input);

        // Then
        assertThat(result)
                .isEqualTo(1);
    }
}