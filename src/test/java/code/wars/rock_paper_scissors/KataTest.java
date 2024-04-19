package code.wars.rock_paper_scissors;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class KataTest {

    public static Stream<Arguments> playerOneWins() {

        return Stream.of(
                Arguments.arguments(
                        "rock", "scissors",
                        "scissors", "paper",
                        "paper", "rock"));
    }

    public static Stream<Arguments> playerTwoWins() {

        return Stream.of(
                Arguments.arguments(
                        "scissors", "rock",
                        "paper", "scissors",
                        "rock", "paper"));
    }

    public static Stream<Arguments> draws() {

        return Stream.of(
                Arguments.arguments(
                        "scissors", "scissors",
                        "paper", "paper",
                        "rock", "rock"));
    }

    @ParameterizedTest
    @MethodSource("playerOneWins")
    public void rps_whenPlayer1Wins_thenReturnPlayer1(
            // Given
            String player1,
            String player2) {

        // When
        final String result = Kata.rps(player1, player2);

        // Then
        assertThat(result)
                .isEqualTo("Player 1 won!");
    }

    @ParameterizedTest
    @MethodSource("playerTwoWins")
    public void rps_whenPlayer2Wins_thenReturnPlayer2(
            // Given
            String player1,
            String player2) {

        // When
        final String result = Kata.rps(player1, player2);

        // Then
        assertThat(result)
                .isEqualTo("Player 2 won!");
    }

    @ParameterizedTest
    @MethodSource("draws")
    public void rps_whenIsDraw_thenReturnDraw(
            // Given
            String player1,
            String player2) {

        // When
        final String result = Kata.rps(player1, player2);

        // Then
        assertThat(result)
                .isEqualTo("Draw!");
    }
}
