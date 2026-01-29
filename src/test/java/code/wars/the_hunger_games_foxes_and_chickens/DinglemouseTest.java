package code.wars.the_hunger_games_foxes_and_chickens;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DinglemouseTest {

    @Test
    void hungryFoxes_whenFoxesAreOutsideCagesWithChickens_eatChickensOutsideCages() {

        // Given
        final String input = "CCC[CCC]FCC[CCCCC]CFFFF[CCC]FFFF";

        // When
        final String result = Dinglemouse.hungryFoxes(input);

        // Then
        assertThat(result)
                .isEqualTo("...[CCC]F..[CCCCC].FFFF[CCC]FFFF");
    }

    @Test
    void hungryFoxes_whenFoxIsInsideCageWithChickens_eatChickensInsideCage() {

        // Given
        final String input = "...[CCC]...[CCCFC].....[CCC]....";

        // When
        final String result = Dinglemouse.hungryFoxes(input);

        // Then
        assertThat(result)
                .isEqualTo("...[CCC]...[...F.].....[CCC]....");
    }

    @Test
    void hungryFoxes_whenFoxesInsideAndOutsideCages_eatChickensInRespectiveAreas() {

        // Given
        final String input = "CCC[CCC]FCC[CCCFC]CFFFF[CCC]FFFF";

        // When
        final String result = Dinglemouse.hungryFoxes(input);

        // Then
        assertThat(result)
                .isEqualTo("...[CCC]F..[...F.].FFFF[CCC]FFFF");
    }
}
