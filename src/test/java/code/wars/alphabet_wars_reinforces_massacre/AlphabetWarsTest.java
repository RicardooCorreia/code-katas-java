package code.wars.alphabet_wars_reinforces_massacre;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AlphabetWarsTest {

    @Test
    void reinforcesMassacre_whenSimpleAirstrikes_returnSurvivors() {

        // Given
        final String[] reinforces = {"abcdefg", "hijklmn"};
        final String[] airstrikes = {"   *   ", "*  *   "};

        // When
        final String result = AlphabetWars.reinforcesMassacre(reinforces, airstrikes);

        // Then
        assertThat(result)
                .isEqualTo("hi___fg");
    }

    @Test
    void reinforcesMassacre_whenMultipleReinforcesAndAirstrikes_returnRemainingCharacters() {

        // Given
        final String[] reinforces = {"aaaaa", "bbbbb", "ccccc", "ddddd"};
        final String[] airstrikes = {"*", " *", "   "};

        // When
        final String result = AlphabetWars.reinforcesMassacre(reinforces, airstrikes);

        // Then
        assertThat(result)
                .isEqualTo("ccbaa");
    }

    @Test
    void reinforcesMassacre_whenComplexScenario_returnExpectedSurvivors() {

        // Given
        final String[] reinforces = {
                "g964xxxxxxxx",
                "myjinxin2015",
                "steffenvogel",
                "smile67xxxxx",
                "giacomosorbi",
                "freywarxxxxx",
                "bkaesxxxxxxx",
                "vadimbxxxxxx",
                "zozofouchtra",
                "colbydauphxx"
        };
        final String[] airstrikes = {
                "* *** ** ***",
                " ** * * * **",
                " * *** * ***",
                " **  * * ** ",
                "* ** *   ***",
                "***   ",
                "**",
                "*",
                "*"
        };

        // When
        final String result = AlphabetWars.reinforcesMassacre(reinforces, airstrikes);

        // Then
        assertThat(result)
                .isEqualTo("codewarsxxxx");
    }
}
