package leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ThreeSumTest {

    private final ThreeSum.Solution subject = new ThreeSum.Solution();

    @Test
    void threeSum_baseExample() {

        // Given
        int[] input = {-1, 0, 1, 2, -1, -4};

        // When
        List<List<Integer>> result = subject.threeSum(input);

        // Then
        assertThat(result)
                .hasSize(2)
                .containsExactlyInAnyOrder(
                        List.of(-1, -1, 2),
                        List.of(-1, 0, 1)
                );
    }

    @Test
    void threeSum_whenDoesNotHavePossible_returnEmpty() {

        // Given
        int[] input = {0, 1, 1};

        // When
        List<List<Integer>> result = subject.threeSum(input);

        // Then
        assertThat(result)
                .isEmpty();
    }

    @Test
    void threeSum_whenDoesSingleHavePossible_returnCorrectSet() {

        // Given
        int[] input = {0, 0, 0};

        // When
        List<List<Integer>> result = subject.threeSum(input);

        // Then
        assertThat(result)
                .containsExactly(List.of(0, 0, 0));
    }

    @Test
    void threeSum_whenComplexExample_returnCorrectSet() {

        // Given
        int[] input = {-2, 0, 1, 1, 2};

        // When
        List<List<Integer>> result = subject.threeSum(input);

        // Then
        assertThat(result)
                .hasSize(2)
                .containsExactlyInAnyOrder(List.of(-2, 0, 2), List.of(-2, 1, 1));
    }
}