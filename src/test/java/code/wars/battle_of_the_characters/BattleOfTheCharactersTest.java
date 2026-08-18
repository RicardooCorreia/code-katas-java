package code.wars.battle_of_the_characters;

import static code.wars.battle_of_the_characters.BattleOfTheCharacters.battle;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BattleOfTheCharactersTest {

    @Nested
    class SecondWinsTests {
        @ParameterizedTest
        @CsvSource({
            "AAA, Z",
            "ONE, TWO"
        })
        void should_returnSecond_when_secondIsStronger(String x, String y) {
            // given
            // input from CsvSource

            // when
            String result = battle(x, y);

            // then
            assertThat(result).isEqualTo(y);
        }
    }

    @Test
    void should_returnFirst_when_firstIsStronger() {
        // given
        String x = "FOUR";
        String y = "FIVE";

        // when
        String result = battle(x, y);

        // then
        assertThat(result).isEqualTo(x);
    }

    @Test
    void should_returnTie_when_bothAreEqual() {
        // given
        String x = "ONE";
        String y = "NEO";

        // when
        String result = battle(x, y);

        // then
        assertThat(result).isEqualTo("Tie!");
    }
}
