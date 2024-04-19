package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FindCommonElementsBetweenTwoArraysTest {

    private final FindCommonElementsBetweenTwoArrays.Solution subject = new FindCommonElementsBetweenTwoArrays.Solution();

    @Test
    void findIntersectionValues_whenHasCommonElements_returnBothCounts() {

        // Given
        int[] input1 = {4, 3, 2, 3, 1};
        int[] input2 = {2, 2, 5, 2, 3, 6};

        // When
        int[] result = subject.findIntersectionValues(input1, input2);

        // Then
        assertThat(result)
                .isEqualTo(new int[]{3, 4});
    }

    @Test
    void findIntersectionValues_whenHasNoCommonElements_returnEmpty() {

        // Given
        int[] input1 = {3, 4, 2, 3};
        int[] input2 = {1, 5};

        // When
        int[] result = subject.findIntersectionValues(input1, input2);

        // Then
        assertThat(result)
                .isEqualTo(new int[]{0, 0});
    }
}