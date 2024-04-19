package code.wars.find_all_pairs;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    public void duplicates_whenHasDuplicates_returnCount() {

        // Given
        int[] array = {1, 2, 5, 6, 5, 2};
        int numOfPairs = 2;

        // When
        int result = Solution.duplicates(array);

        // Then
        assertThat(result)
                .isEqualTo(numOfPairs);
    }

    @Test
    void duplicates_whenHasMoreDuplicates_returnCount() {

        // Given
        int[] array = new int[]{1, 2, 2, 20, 6, 20, 2, 6, 2};
        int numOfPairs = 4;

        // When
        int result = Solution.duplicates(array);

        // Then
        assertThat(result)
                .isEqualTo(numOfPairs);
    }

    @Test
    void duplicates_whenHasOnlyDuplicates_returnNumbersDividedByPairs() {

        // Given
        int[] array = new int[]{0, 0, 0, 0, 0, 0, 0};
        int numOfPairs = 3;

        // When
        int result = Solution.duplicates(array);

        // Then
        assertThat(result)
                .isEqualTo(numOfPairs);
    }

    @Test
    void duplicates_whenEmpty_returnZero() {

        // Given
        int[] array = new int[]{};
        int numOfPairs = 0;

        // When
        int result = Solution.duplicates(array);

        // Then
        assertThat(result)
                .isEqualTo(numOfPairs);
    }

    @Test
    void duplicates_whenHasNoDuplicates_returnZero() {

        // Given
        int[] array = new int[]{54};
        int numOfPairs = 0;

        // When
        int result = Solution.duplicates(array);

        // Then
        assertThat(result)
                .isEqualTo(numOfPairs);
    }
}
