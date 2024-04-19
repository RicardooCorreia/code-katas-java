package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CountElementsWithMaximumFrequencyTest {

    private final CountElementsWithMaximumFrequency.Solution subject = new CountElementsWithMaximumFrequency.Solution();

    @Test
    void maxFrequencyElements_whenSomeElementsAreMoreFrequent_considerJustThatSubset() {

        // Given
        int[] input = {1, 2, 2, 3, 1, 4};

        // When
        int result = subject.maxFrequencyElements(input);

        // Then
        assertThat(result)
                .isEqualTo(4);
    }

    @Test
    void maxFrequencyElements_whenAllElementsHaveTheSameFrequency_considerAll() {

        // Given
        int[] input = {1, 2, 3, 4, 5};

        // When
        int result = subject.maxFrequencyElements(input);

        // Then
        assertThat(result)
                .isEqualTo(5);
    }
}