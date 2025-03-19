package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CarPoolingTest {

    private CarPooling.Solution subject = new CarPooling.Solution();

    @Test
    void carPooling_whenNotPossible_returnFalse() {

        // Given
        int[][] input = {{2, 1, 5}, {3, 3, 7}};
        int capacity = 4;

        // When
        boolean result = subject.carPooling(input, capacity);

        // Then
        assertFalse(result);
    }

    @Test
    void carPooling_whenPossible_returnTrue() {

        // Given
        int[][] input = {{2, 1, 5}, {3, 3, 7}};
        int capacity = 5;

        // When
        boolean result = subject.carPooling(input, capacity);

        // Then
        assertTrue(result);
    }

    @Test
    void carPooling_complexExample_returnTrue() {

        // Given
        int[][] input = {{4, 5, 6}, {6, 4, 7}, {4, 3, 5}, {2, 3, 5}};
        int capacity = 13;

        //

        // When
        boolean result = subject.carPooling(input, capacity);

        // Then
        assertTrue(result);
    }
}