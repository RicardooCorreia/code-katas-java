package code.wars.prize_draw;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @Test
    void nthRank_whenHasParticipants_returnParticipant() {

        // Given
        String participants = "Elijah,Chloe,Elizabeth,Matthew,Natalie,Jayden";
        Integer[] weights = {1, 3, 5, 5, 3, 6};
        int n = 2;

        // When
        String result = Rank.nthRank(participants, weights, n);

        // Then
        assertThat(result)
                .isEqualTo("Matthew");
    }

    @Test
    void nthRank_whenHasNoParticipants_returnNoParticipants() {

        // Given
        String participants = "";
        Integer[] weights = {4, 2, 1, 4, 3, 1, 2};
        int n = 4;

        // When
        String result = Rank.nthRank(participants, weights, n);

        // Then
        assertThat(result)
                .isEqualTo("No participants");
    }

    @Test
    void nthRank_whenHasNotEnoughParticipants_returnNotEnoughParticipants() {

        // Given
        String participants = "Addison,Jayden,Sofia,Michael,Andrew,Lily,Benjamin";
        Integer[] weights = {4, 2, 1, 4, 3, 1, 2};
        int n = 8;

        // When
        String result = Rank.nthRank(participants, weights, n);

        // Then
        assertThat(result)
                .isEqualTo("Not enough participants");
    }
}
