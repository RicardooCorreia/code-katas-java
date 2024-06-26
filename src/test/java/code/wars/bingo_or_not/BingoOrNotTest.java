package code.wars.bingo_or_not;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BingoOrNotTest {

    @Test
    public void bingo_whenHasNoBingo_returnLose() {

        // Given
        final int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // When
        final String result = BingoOrNot.bingo(input);

        // Then
        assertThat(result).isEqualTo("LOSE");
    }

    @Test
    public void bingo_whenHasBingo_returnWin() {

        // Given
        final int[] input = {21, 13, 2, 7, 5, 14, 7, 15, 9, 10};


        // When
        final String result = BingoOrNot.bingo(input);

        // Then
        assertThat(result).isEqualTo("WIN");
    }
}
