package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FindLuckyIntegerInAnArrayTest {

    private final FindLuckyIntegerInAnArray.Solution subject = new FindLuckyIntegerInAnArray.Solution();

    @Test
    void findLucky_whenHasLucky_returnNumber() {

        // Given
        int[] input = {2, 2, 3, 4};

        // When
        int result = subject.findLucky(input);

        // Then
        assertThat(result)
                .isEqualTo(2);
    }

    @Test
    void findLucky_whenMultipleHasLucky_returnLargestNumber() {

        // Given
        int[] input = {1, 2, 2, 3, 3, 3};

        // When
        int result = subject.findLucky(input);

        // Then
        assertThat(result)
                .isEqualTo(3);
    }

    @Test
    void findLucky_whenHasNoLucky_returnMinusOne() {

        // Given
        int[] input = {2, 2, 2, 3, 3};

        // When
        int result = subject.findLucky(input);

        // Then
        assertThat(result)
                .isEqualTo(-1);
    }
}