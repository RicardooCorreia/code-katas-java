package code.wars.multiplication_table;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MultiplicationTest {

    @Test
    void multiplicationTable_whenNormalNumber_generateTable() {

        // Given
        int input = 3;

        // When
        int[][] result = Multiplication.multiplicationTable(input);

        // Then
        int[][] expected = {{1, 2, 3}, {2, 4, 6}, {3, 6, 9}};
        assertThat(result)
                .isEqualTo(expected);
    }

    @Test
    void multiplicationTable_whenIsOne_returnJustOne() {

        // Given
        int input = 1;

        // When
        int[][] result = Multiplication.multiplicationTable(input);

        // Then
        int[][] expected = {{1}};
        assertThat(result)
                .isEqualTo(expected);
    }

    @Test
    void multiplicationTable_whenIsZero_returnEmpty() {

        // Given
        int input = 0;

        // When
        int[][] result = Multiplication.multiplicationTable(input);

        // Then
        int[][] expected = {};
        assertThat(result)
                .isEqualTo(expected);
    }

    @Test
    void multiplicationTableAlternative_whenNormalNumber_generateTable() {

        // Given
        int input = 3;

        // When
        int[][] result = Multiplication.multiplicationTableAlternative(input);

        // Then
        int[][] expected = {{1, 2, 3}, {2, 4, 6}, {3, 6, 9}};
        assertThat(result)
                .isEqualTo(expected);
    }

    @Test
    void multiplicationTableAlternative_whenIsOne_returnJustOne() {

        // Given
        int input = 1;

        // When
        int[][] result = Multiplication.multiplicationTableAlternative(input);

        // Then
        int[][] expected = {{1}};
        assertThat(result)
                .isEqualTo(expected);
    }

    @Test
    void multiplicationTableAlternative_whenIsZero_returnEmpty() {

        // Given
        int input = 0;

        // When
        int[][] result = Multiplication.multiplicationTableAlternative(input);

        // Then
        int[][] expected = {};
        assertThat(result)
                .isEqualTo(expected);
    }

    @Test
    void multiplicationTable_whenIsNegative_returnNull() {

        // Given
        int input = -1;

        // When
        int[][] result = Multiplication.multiplicationTable(input);

        // Then
        assertThat(result)
                .isNull();
    }
}
