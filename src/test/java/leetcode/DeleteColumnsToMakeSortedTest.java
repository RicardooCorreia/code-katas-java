package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DeleteColumnsToMakeSortedTest {

    private final DeleteColumnsToMakeSorted.Solution subject = new DeleteColumnsToMakeSorted.Solution();

    @Test
    void minDeletionSize_whenOneColumnNeedsToBeDeleted_returnOne() {

        // Given
        String[] input = {"cba", "daf", "ghi"};

        // When
        int result = subject.minDeletionSize(input);

        // Then
        assertThat(result)
                .isEqualTo(1);
    }

    @Test
    void minDeletionSize_whenNoColumnNeedsToBeDeleted_returnZero() {

        // Given
        String[] input = {"a", "b"};

        // When
        int result = subject.minDeletionSize(input);

        // Then
        assertThat(result)
                .isEqualTo(0);
    }

    @Test
    void minDeletionSize_whenAllColumnNeedsToBeDeleted_returnAll() {

        // Given
        String[] input = {"zyx", "wvu", "tsr"};

        // When
        int result = subject.minDeletionSize(input);

        // Then
        assertThat(result)
                .isEqualTo(3);
    }
}