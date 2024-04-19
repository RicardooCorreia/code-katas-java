package haker.rank.sherlock_and_squares;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @Test
    void squares_whenTheresSquares_returnCount() {

        // Given
        final int a = 3;
        final int b = 9;

        // When
        final int result = Result.squares(a, b);

        // Then
        assertThat(result)
                .isEqualTo(2);
    }

    @Test
    void squares_whenThereIsNotSquares_returnZeroCount() {

        // Given
        final int a = 17;
        final int b = 24;

        // When
        final int result = Result.squares(a, b);

        // Then
        assertThat(result)
                .isEqualTo(0);
    }

    @Test
    void squares_whenThereIsNotSquares_returnZeroCount2() {

        // Given
        final int a = 100;
        final int b = 1000;

        // When
        final int result = Result.squares(a, b);

        // Then
        assertThat(result)
                .isEqualTo(22);
    }
}