package leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FindAllNumbersDisappearedInAnArrayTest {

    private final FindAllNumbersDisappearedInAnArray.Solution subject = new FindAllNumbersDisappearedInAnArray.Solution();

    @Test
    void findDisappearedNumbers_whenTheresMissingNumbers_returnNumbers() {

        // Given
        int[] input = {4, 3, 2, 7, 8, 2, 3, 1};

        // When
        List<Integer> result = subject.findDisappearedNumbers(input);

        // Then
        assertThat(result)
                .containsExactlyInAnyOrder(5, 6);
    }

    @Test
    void findDisappearedNumbers_shortExample() {

        // Given
        int[] input = {1, 1};

        // When
        List<Integer> result = subject.findDisappearedNumbers(input);

        // Then
        assertThat(result)
                .containsExactlyInAnyOrder(2);
    }
}