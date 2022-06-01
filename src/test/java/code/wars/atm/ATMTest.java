package code.wars.atm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ATMTest {

    @Test
    void solve_whenCannotGiveCorrectAmount_returnNegative() {

        // Given
        final int input = 125;

        // When
        final int result = new ATM().solve(input);

        // Then
        assertThat(result)
                .isEqualTo(-1);
    }

    @Test
    void solve_whenCanGiveCorrectAmount_returnNumberOfBankNotes() {

        // Given
        final int input = 770;

        // When
        final int result = new ATM().solve(input);

        // Then
        assertThat(result)
                .isEqualTo(4);
    }

    @Test
    void solve_whenCanGiveMultipleNotes_returnNumberOfBankNotes() {

        // Given
        final int input = 1500;

        // When
        final int result = new ATM().solve(input);

        // Then
        assertThat(result)
                .isEqualTo(3);
    }
}
