package other;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class TopScoresTest {

    private final TopScores subject = new TopScores();

    public static Stream<Arguments> samePointsScenarios() {

        return Stream.of(
                Arguments.arguments(new int[]{1, 0, 3, 4, 2}, new int[]{2, 0, 1, 2, 0}, 5, 0),
                Arguments.arguments(new int[]{5, 2, 3, 0, 4, 1}, new int[]{0, 2, 2, 1, 0, 1}, 3, 1),
                Arguments.arguments(new int[]{1, 0, 3, 2}, new int[]{0, 1, 0, 1}, 2, 1),
                Arguments.arguments(new int[]{0, 1, 2, 3, 4, 5, 6}, new int[]{0, 1, 2, 2, 0, 1}, 3, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("samePointsScenarios")
    void findWinner_whenHasTheSamePointsButReachedFirst_returnFirstToReachThePoints() {

        // Given
        int[] timeScored = {1, 0, 3, 4, 2};
        int[] playerIds = {2, 0, 1, 2, 0};
        int numberOfPlayers = 5;

        // When
        int result = subject.findWinner(timeScored, playerIds, numberOfPlayers);

        // Then
        assertThat(result)
                .isEqualTo(0);
    }

    @Test
    void findWinner_whenHasMorePoints_returnPlayerWithMostPoints() {

        // Given
        int[] timeScored = {1, 0, 3, 2, 4, 5, 7, 6};
        int[] playerIds = {1, 0, 3, 2, 4, 0, 1, 0};
        int numberOfPlayers = 5;

        // When
        int result = subject.findWinner(timeScored, playerIds, numberOfPlayers);

        // Then
        assertThat(result)
                .isEqualTo(0);
    }
}
