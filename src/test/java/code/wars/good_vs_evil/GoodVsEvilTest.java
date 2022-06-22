package code.wars.good_vs_evil;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GoodVsEvilTest {

    @Test
    public void battle_whenHasMoreEvil_returnEvilWins() {

        // Given
        final String good = "1 1 1 1 1 1";
        final String evil = "1 1 1 1 1 1 1";

        // When
        final String result = GoodVsEvil.battle(good, evil);

        // Then
        assertThat(result)
                .isEqualTo("Battle Result: Evil eradicates all trace of Good");
    }

    @Test
    public void battle_whenHasMoreGood_returnGoodWins() {

        // Given
        final String good = "0 0 0 0 0 10";
        final String evil = "0 1 1 1 1 0 0";

        // When
        final String result = GoodVsEvil.battle(good, evil);

        // Then
        assertThat(result)
                .isEqualTo("Battle Result: Good triumphs over Evil");
    }

    @Test
    public void battle_whenHasMoreEvilCountButGreaterGoodWorth_returnEvilWins() {

        // Given
        final String good = "0 0 0 0 0 1";
        final String evil = "9 0 0 0 0 0 0";

        // When
        final String result = GoodVsEvil.battle(good, evil);

        // Then
        assertThat(result)
                .isEqualTo("Battle Result: Good triumphs over Evil");
    }

    @Test
    public void battle_whenSameAmount_returnTie() {

        // Given
        final String good = "1 0 0 0 0 0";
        final String evil = "1 0 0 0 0 0 0";

        // When
        final String result = GoodVsEvil.battle(good, evil);

        // Then
        assertThat(result)
                .isEqualTo("Battle Result: No victor on this battle field");
    }
}
