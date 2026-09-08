package code.wars.snake_and_ladders;

import java.util.Map;

import static java.util.Map.entry;

public class SnakesLadders {

    private static final Map<Integer, Integer> TRANSPORTS = Map.ofEntries(
        // Ladders
        entry(2, 38),
        entry(7, 14),
        entry(8, 31),
        entry(15, 26),
        entry(21, 42),
        entry(28, 84),
        entry(36, 44),
        entry(51, 67),
        entry(71, 91),
        entry(78, 98),
        entry(87, 94),
        // Snakes
        entry(16, 6),
        entry(46, 25),
        entry(49, 11),
        entry(62, 19),
        entry(64, 60),
        entry(74, 53),
        entry(89, 68),
        entry(92, 88),
        entry(95, 75),
        entry(99, 80)
    );

    private final Player player1;
    private final Player player2;
    private Player currentPlaying;
    private boolean gameOver;

    public SnakesLadders() {
        player1 = new Player(1, 0);
        player2 = new Player(2, 0);
        currentPlaying = player1;
        gameOver = false;
    }

    public String play(int die1, int die2) {

        if (gameOver) {
            return "Game over!";
        }
        final var newerPosition = resolvePosition(currentPlaying.position, die1 + die2);
        if (newerPosition == 100) {
            gameOver = true;
            return "Player %s Wins!".formatted(currentPlaying.order);
        }

        currentPlaying.position = newerPosition;

        try {
            return "Player %s is on square %s".formatted(currentPlaying.order, currentPlaying.position);
        } finally {
            if (die1 != die2) {
                switchPlayer();
            }
        }
    }

    private int resolvePosition(int position, int dice) {
        final var newPosition = position + dice;
        final var landingSquare = newPosition > 100 ? 200 - newPosition : newPosition;
        return TRANSPORTS.getOrDefault(landingSquare, landingSquare);
    }

    private void switchPlayer() {
        currentPlaying = currentPlaying == player1 ? player2 : player1;
    }

    public static final class Player {

        private final int order;
        private int position;

        public Player(int order, int position) {
            this.order = order;
            this.position = position;
        }

        public int order() {
            return order;
        }

        public int position() {
            return position;
        }
    }
}
