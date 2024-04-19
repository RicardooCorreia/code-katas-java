package code.wars.who_won_the_election;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BallotsCounterTest {

    @Test
    void getWinner_whenSingleVote_returnWinner() {

        // Given
        final List<String> votes = List.of("A");

        // When
        final String result = BallotsCounter.getWinner(votes);

        // Then
        assertThat(result)
                .isEqualTo("A");
    }

    @Test
    void getWinner_whenHasMajority_returnWinner() {

        // Given
        final List<String> votes = List.of("A", "A", "A", "B", "B", "B", "A");

        // When
        final String result = BallotsCounter.getWinner(votes);

        // Then
        assertThat(result)
                .isEqualTo("A");
    }

    @Test
    void getWinner_whenIsTied_returnNull() {

        // Given
        final List<String> votes = List.of("A", "A", "A", "B", "B", "B");

        // When
        final String result = BallotsCounter.getWinner(votes);

        // Then
        assertThat(result)
                .isNull();
    }

    @Test
    void getWinner_whenWonButDoNotHasMajority_returnNull() {

        // Given
        final List<String> votes = List.of("A", "A", "A", "B", "C", "B");

        // When
        final String result = BallotsCounter.getWinner(votes);

        // Then
        assertThat(result)
                .isNull();
    }
}
