package code.wars.tic_tac_toe_checker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void isSolved_whenNotFinished_returnMinus1() {

        // Given
        int[][] input = {
                {0, 0, 1},
                {0, 1, 2},
                {2, 1, 0}
        };

        // When
        int result = Solution.isSolved(input);

        // Then
        assertThat(result).isEqualTo(-1);
    }

    @Test
    void isSolved_whenWinnerX_return1() {

        // Given
        int[][] input = {
                {1, 1, 1},
                {0, 2, 2},
                {0, 0, 0}
        };

        // When
        int result = Solution.isSolved(input);

        // Then
        assertThat(result).isEqualTo(1);
    }

    @Test
    void isSolved_whenWinnerXVertical_return1() {

        // Given
        int[][] input = {
                {1, 2, 1},
                {0, 2, 1},
                {0, 0, 1}
        };

        // When
        int result = Solution.isSolved(input);

        // Then
        assertThat(result).isEqualTo(1);
    }

    @Test
    void isSolved_whenWinnerXHorizontal_return1() {

        // Given
        int[][] input = {
                {1, 2, 1},
                {0, 2, 2},
                {1, 1, 1}
        };

        // When
        int result = Solution.isSolved(input);

        // Then
        assertThat(result).isEqualTo(1);
    }

    @Test
    void isSolved_whenWinnerXCrossing_return1() {

        // Given
        int[][] input = {
                {1, 2, 1},
                {0, 1, 2},
                {1, 2, 1}
        };

        // When
        int result = Solution.isSolved(input);

        // Then
        assertThat(result).isEqualTo(1);
    }

    @Test
    void isSolved_whenWinnerO_return2() {

        // Given
        int[][] input = {
                {1, 1, 2},
                {0, 2, 0},
                {2, 1, 1}
        };

        // When
        int result = Solution.isSolved(input);

        // Then
        assertThat(result).isEqualTo(2);
    }

    @Test
    void isSolved_whenIsDraw_returnZero() {

        // Given
        int[][] input = {
                {1, 2, 1},
                {1, 1, 2},
                {2, 1, 2}
        };

        // When
        int result = Solution.isSolved(input);

        // Then
        assertThat(result).isEqualTo(0);
    }
}
