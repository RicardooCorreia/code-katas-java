package code.wars.snake_and_ladders;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class SnakesLaddersTest {

    @Test
    void should_returnExpectedSquares_when_playingExampleSequence() {
        // given
        SnakesLadders game = new SnakesLadders();

        // when
        var results = playAll(game, new int[][] {{1, 1}, {1, 5}, {6, 2}, {1, 1}});

        // then
        assertThat(results).containsExactly(
                "Player 1 is on square 38",
                "Player 1 is on square 44",
                "Player 2 is on square 31",
                "Player 1 is on square 25");
    }

    @Test
    void should_returnExpectedSquares_when_playingRandomRollSequence() {
        // given
        SnakesLadders game = new SnakesLadders();

        // when
        var results = playAll(game, new int[][] {{4, 6}, {3, 2}, {3, 3}, {2, 1}});

        // then
        assertThat(results).containsExactly(
                "Player 1 is on square 10",
                "Player 2 is on square 5",
                "Player 1 is on square 6",
                "Player 1 is on square 9");
    }

    @Nested
    class WinningTests {

        @Test
        void should_returnWinMessage_when_player1ReachesSquare100() {
            // given
            SnakesLadders game = new SnakesLadders();

            // when
            var results = playAll(game, new int[][] {{6, 6}, {6, 6}, {2, 2}, {6, 6}, {3, 1}});

            // then
            assertThat(results).containsExactly(
                    "Player 1 is on square 12",
                    "Player 1 is on square 24",
                    "Player 1 is on square 84",
                    "Player 1 is on square 96",
                    "Player 1 Wins!");
        }

        @Test
        void should_returnWinMessage_when_player2ReachesSquare100() {
            // given
            SnakesLadders game = new SnakesLadders();

            // when
            var results = playAll(game,
                    new int[][] {{1, 2}, {6, 6}, {6, 6}, {2, 2}, {6, 6}, {3, 1}});

            // then
            assertThat(results).containsExactly(
                    "Player 1 is on square 3",
                    "Player 2 is on square 12",
                    "Player 2 is on square 24",
                    "Player 2 is on square 84",
                    "Player 2 is on square 96",
                    "Player 2 Wins!");
        }
    }

    @Nested
    class GameOverTests {

        @Test
        void should_returnGameOver_when_playingAfterNormalWin() {
            // given
            SnakesLadders game = new SnakesLadders();

            // when
            var results = playAll(game,
                    new int[][] {{6, 6}, {6, 6}, {2, 2}, {6, 6}, {3, 1}, {1, 2}});

            // then
            assertThat(results).containsExactly(
                    "Player 1 is on square 12",
                    "Player 1 is on square 24",
                    "Player 1 is on square 84",
                    "Player 1 is on square 96",
                    "Player 1 Wins!",
                    "Game over!");
        }

        @Test
        void should_returnGameOver_when_playingAfterDoubleRollWin() {
            // given
            SnakesLadders game = new SnakesLadders();

            // when
            var results = playAll(game,
                    new int[][] {{6, 6}, {6, 6}, {2, 2}, {6, 6}, {2, 2}, {1, 2}});

            // then
            assertThat(results).containsExactly(
                    "Player 1 is on square 12",
                    "Player 1 is on square 24",
                    "Player 1 is on square 84",
                    "Player 1 is on square 96",
                    "Player 1 Wins!",
                    "Game over!");
        }
    }

    @Nested
    class BounceTests {

        @Test
        void should_bounceBackTo97_when_rollingPastSquare100() {
            // given
            SnakesLadders game = new SnakesLadders();

            // when
            var results = playAll(game, new int[][] {
                    {6, 6}, {6, 6}, {5, 5}, {5, 5}, {6, 6}, {6, 6}, {6, 6}, {6, 6}, {5, 5}, {2, 3}});

            // then
            assertThat(results).containsExactly(
                    "Player 1 is on square 12",
                    "Player 1 is on square 24",
                    "Player 1 is on square 34",
                    "Player 1 is on square 44",
                    "Player 1 is on square 56",
                    "Player 1 is on square 68",
                    "Player 1 is on square 80",
                    "Player 1 is on square 88",
                    "Player 1 is on square 98",
                    "Player 1 is on square 97");
        }

        @Test
        void should_keepTurn_when_doubleRollBouncesBack() {
            // given
            SnakesLadders game = new SnakesLadders();

            // when
            var results = playAll(game, new int[][] {
                    {6, 6}, {6, 6}, {5, 5}, {5, 5}, {6, 6}, {6, 6}, {6, 6}, {6, 6}, {5, 5}, {6, 6}, {1, 2}});

            // then
            assertThat(results).containsExactly(
                    "Player 1 is on square 12",
                    "Player 1 is on square 24",
                    "Player 1 is on square 34",
                    "Player 1 is on square 44",
                    "Player 1 is on square 56",
                    "Player 1 is on square 68",
                    "Player 1 is on square 80",
                    "Player 1 is on square 88",
                    "Player 1 is on square 98",
                    "Player 1 is on square 90",
                    "Player 1 is on square 93");
        }

        @Test
        void should_slideDownSnake_when_bounceLandsOnSnakeTop() {
            // given
            SnakesLadders game = new SnakesLadders();

            // when
            var results = playAll(game, new int[][] {
                    {6, 6}, {6, 6}, {5, 5}, {5, 5}, {6, 6}, {6, 6}, {6, 6}, {6, 6}, {5, 5}, {1, 2}});

            // then
            assertThat(results).containsExactly(
                    "Player 1 is on square 12",
                    "Player 1 is on square 24",
                    "Player 1 is on square 34",
                    "Player 1 is on square 44",
                    "Player 1 is on square 56",
                    "Player 1 is on square 68",
                    "Player 1 is on square 80",
                    "Player 1 is on square 88",
                    "Player 1 is on square 98",
                    "Player 1 is on square 80");
        }
    }

    @Nested
    class SnakeAndLadderTests {

        @Test
        void should_climbLadder_when_landingOnLadderBottom() {
            // given
            SnakesLadders game = new SnakesLadders();

            // when
            var results = playAll(game, new int[][] {{6, 6}, {4, 5}});

            // then
            assertThat(results).containsExactly(
                    "Player 1 is on square 12",
                    "Player 1 is on square 42");
        }

        @Test
        void should_slideDownSnake_when_landingOnSnakeTop() {
            // given
            SnakesLadders game = new SnakesLadders();

            // when
            var results = playAll(game, new int[][] {{2, 2}, {6, 6}});

            // then
            assertThat(results).containsExactly(
                    "Player 1 is on square 4",
                    "Player 1 is on square 6");
        }
    }

    private List<String> playAll(SnakesLadders game, int[][] rolls) {
        var results = new ArrayList<String>();
        for (int[] roll : rolls) {
            results.add(game.play(roll[0], roll[1]));
        }
        return results;
    }
}