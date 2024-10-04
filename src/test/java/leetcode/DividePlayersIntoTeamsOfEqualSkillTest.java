package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DividePlayersIntoTeamsOfEqualSkillTest {

    private final DividePlayersIntoTeamsOfEqualSkill.Solution subject = new DividePlayersIntoTeamsOfEqualSkill.Solution();

    @Test
    void dividePlayers_whenHasPossibleTeams_returnCorrect() {
        // Given
        int[] skill = {3, 2, 5, 1, 3, 4};

        // When
        long result = subject.dividePlayers(skill);

        // Then
        assertThat(result).isEqualTo(22);
    }

    @Test
    void dividePlayers_whenHasSinglePossibleTeams_returnCorrect() {
        // Given
        int[] skill = {3, 4};

        // When
        long result = subject.dividePlayers(skill);

        // Then
        assertThat(result).isEqualTo(12);
    }

    @Test
    void dividePlayers_whenDoesNotHavePossibleTeams_returnMinusOne() {
        // Given
        int[] skill = {1, 1, 2, 3};

        // When
        long result = subject.dividePlayers(skill);

        // Then
        assertThat(result).isEqualTo(-1);
    }
}