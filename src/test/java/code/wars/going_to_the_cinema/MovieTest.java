package code.wars.going_to_the_cinema;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MovieTest {

    @Test
    public void movie() {

        // Given
        final int card = 500;
        final int ticket = 15;
        final double perc = 0.9;

        // When
        final int result = Movie.movie(card, ticket, perc);

        // Then
        assertThat(result)
                .isEqualTo(43);
    }
}
