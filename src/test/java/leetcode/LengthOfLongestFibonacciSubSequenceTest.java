package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LengthOfLongestFibonacciSubSequenceTest {

    private final LengthOfLongestFibonacciSubSequence.Solution subject = new LengthOfLongestFibonacciSubSequence.Solution();

    @Test
    void lenLongestFibSubseq() {
        // Given
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8};
        int expected = 5;

        // When
        int result = subject.lenLongestFibSubseq(input);

        // Then
        assertEquals(expected, result);
    }

    @Test
    void lenLongestFibSubseq_example2() {
        // Given
        int[] input = {1, 3, 7, 11, 12, 14, 18};
        int expected = 3;

        // When
        int result = subject.lenLongestFibSubseq(input);

        // Then
        assertEquals(expected, result);
    }

}