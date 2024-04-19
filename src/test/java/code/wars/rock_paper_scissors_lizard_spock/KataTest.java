package code.wars.rock_paper_scissors_lizard_spock;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class KataTest {

    public static Stream<Arguments> playerOneWins() {

        return Stream.of(
                arguments("rock", "lizard"),
                arguments("paper", "rock"),
                arguments("scissors", "lizard"),
                arguments("lizard", "paper"),
                arguments("spock", "rock")
        );
    }

    public static Stream<Arguments> playerTwoWins() {

        return Stream.of(
                arguments("lizard", "scissors"),
                arguments("spock", "lizard"),
                arguments("paper", "lizard"),
                arguments("scissors", "spock"),
                arguments("rock", "spock")
        );
    }

    public static Stream<Arguments> draws() {

        return Stream.of(
                arguments("rock", "rock"),
                arguments("spock", "spock")
        );
    }

    @ParameterizedTest
    @MethodSource("playerOneWins")
    void rpsls_whenPlayer1Wins_returnPlayer1(
            // Given
            String player1,
            String player2) {

        // When
        final String result = Kata.rpsls(player1, player2);

        // Then
        assertThat(result)
                .isEqualTo("Player 1 Won!");
    }

    @ParameterizedTest
    @MethodSource("playerTwoWins")
    void rpsls_whenPlayer2Wins_returnPlayer2(
            // Given
            String player1,
            String player2) {

        // When
        final String result = Kata.rpsls(player1, player2);

        // Then
        assertThat(result)
                .isEqualTo("Player 2 Won!");
    }

    @ParameterizedTest
    @MethodSource("draws")
    void rpsls_whenIsDraw_returnDrawn(
            // Given
            String player1,
            String player2) {

        // When
        final String result = Kata.rpsls(player1, player2);

        // Then
        assertThat(result)
                .isEqualTo("Draw!");
    }
}
