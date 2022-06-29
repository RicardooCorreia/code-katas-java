package code.wars.simple_card_game;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    private final Game subject = new Game();

    @Test
    public void winner_whenSteveWins_returnSteveWithScore() {

        // Given
        final String[] steveDeck = {"A", "7", "8"};
        final String[] joshDeck = {"K", "5", "9"};

        // When
        final String result = subject.winner(steveDeck, joshDeck);

        // Then
        assertThat(result)
                .isEqualTo("Steve wins 2 to 1");
    }

    @Test
    public void winner_whenIsTie_returnTie() {

        // Given
        final String[] steveDeck = {"T"};
        final String[] joshDeck = {"T"};

        // When
        final String result = subject.winner(steveDeck, joshDeck);

        // Then
        assertThat(result)
                .isEqualTo("Tie");
    }
}
