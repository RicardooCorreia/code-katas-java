package code.wars.remove_duplicates;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UniqueArrayTest {

    @Test
    void unique_whenHasNoDuplicates_returnSameArray() {

        // Given
        final int[] input = {1, 2, 5, 7, 10};

        // When
        final int[] result = UniqueArray.unique(input);

        // Then
        assertThat(result)
                .isEqualTo(input);
    }

    @Test
    void unique_whenHasDuplicates_returnArrayWithoutDuplicates() {

        // Given
        final int[] input = {1, 2, 5, 7, 10, 2};

        // When
        final int[] result = UniqueArray.unique(input);

        // Then
        assertThat(result)
                .containsExactly(1, 2, 5, 7, 10);
    }

    @Test
    void unique_whenHasMultipleDuplicates_returnArrayWithoutDuplicates() {

        // Given
        final int[] input = {1, 2, 5, 2, 2, 7, 5, 10, 1, 2};

        // When
        final int[] result = UniqueArray.unique(input);

        // Then
        assertThat(result)
                .containsExactly(1, 2, 5, 7, 10);
    }
}
