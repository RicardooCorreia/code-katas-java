package leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FindAllDuplicatesInAnArrayTest {

    private final FindAllDuplicatesInAnArray.Solution subject = new FindAllDuplicatesInAnArray.Solution();

    @Test
    void findDuplicates_whenHasOnlyOneDuplicate_returnNumber() {

        // Given
        int[] input = {1, 1, 2};

        // When
        List<Integer> result = subject.findDuplicates(input);

        // Then
        assertThat(result)
                .containsExactly(1);
    }

    @Test
    void findDuplicates_whenHasOnlyMultipleDuplicate_returnNumbers() {

        // Given
        int[] input = {4, 3, 2, 7, 8, 2, 3, 1};

        // When
        List<Integer> result = subject.findDuplicates(input);

        // Then
        assertThat(result)
                .containsExactlyInAnyOrder(2, 3);
    }

    @Test
    void findDuplicates_whenNoDuplicates_returnEmpty() {

        // Given
        int[] input = {1};

        // When
        List<Integer> result = subject.findDuplicates(input);

        // Then
        assertThat(result)
                .isEmpty();
    }
}