package other;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TopScores {

    /**
     * You are playing a timed game with some friends. The winner of the game is the player that gets the
     * most points first in fixed time period. Given score tables find the winner!
     * <p>
     * For example, Let's say we have three players ids 0, 1 and 2.
     * The history of scored events is scrambled (not ordered by time) and would look something like this
     * time   : 1, 0, 3, 4, 2
     * player : 2, 0, 1, 2, 0
     * At time 1, player 2 scores. At time 0, player 0 scores. At time 3, 1 scores. At time 4, 2 scores. At time 2, 0 scores.
     * The winner is the one with the highest score that got there first. In this example it's 0.
     * Both 0 and 2 have the same score however 0 got there first.
     * <p>
     * Here are some more examples:
     * findWinner({1, 0, 3, 4, 2}, {2, 0, 1, 2, 0}, 5) should return 0
     * findWinner({1, 0, 3, 2, 4, 5, 7, 6}, {1, 0, 3, 2, 4, 0, 1, 0}, 5) should return 0
     * findWinner({5, 2, 3, 0, 4, 1}, {0, 2, 2, 1, 0, 1}, 3) should return 1
     * findWinner({1, 0}, {0, 0}, 1) should return 0
     * findWinner({1, 0, 3, 2}, {0, 1, 0, 1}, 2) should return 1
     * findWinner({0, 1, 2, 3, 4, 5, 6}, {0, 1, 2, 2, 0, 1}, 3) should return 2
     * <p>
     * Constraints:
     * timeScored and playerIds will always have at least one element
     * Player ids inside the playerIds array will always be in the range of [0, numberOfPlayers - 1]
     * Each time is unique in the timeScored array, i.e. no two times are the same
     * numberOfPlayers will always be in the range between [1, 100]
     **/
    public int findWinner(int[] timeScored, int[] playerIds, int numberOfPlayers) {

        return IntStream.range(0, timeScored.length)
                .mapToObj(i -> Map.entry(timeScored[i], playerIds[i]))
                .collect(Collectors.groupingBy(Map.Entry::getKey,
                                               HashMap::new,
                                               Collectors.reducing(
                                                       new PlayerScore(0, 0, 0),
                                                       entry -> new PlayerScore(entry.getValue(), 1, entry.getValue()),
                                                       (playerScore, playerScore2) -> playerScore.incrementScore(playerScore2.time()))))
                .entrySet()
                .stream()
                .min((o1, o2) -> {
                    PlayerScore playerScore1 = o1.getValue();
                    PlayerScore playerScore2 = o2.getValue();

                    int scoreDifference = playerScore2.score() - playerScore1.score();
                    if (scoreDifference == 0) {
                        return playerScore1.time() - playerScore2.time();
                    } else {
                        return scoreDifference;
                    }
                })
                .orElseThrow()
                .getKey();
    }

    private record PlayerScore(int player, int score, int time) {

        public static final PlayerScore EMPTY = new PlayerScore(-1, -1, -1);

        public PlayerScore incrementScore(int time) {

            return new PlayerScore(player, score + 1, Math.max(time, this.time));
        }
    }
}
