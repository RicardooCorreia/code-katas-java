package code.wars.alphabet_war_airstrike_letters_massacre;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class AlphabetWarAirstrikeTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "z",
            "zz*zzs"
    })
    void alphabetWar_whenRightWins_returnCorrectString(
            // Given
            String input
    ) {

        // When
        String result = AlphabetWarAirstrike.alphabetWar(input);

        // Then
        assertThat(result)
                .isEqualTo("Right side wins!");
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "sz**z**zs",
            "z*z*z*zs",
            "*wwwwww*z*"
    })
    void alphabetWar_whenLeftWins_returnCorrectString(
            // Given
            String input
    ) {

        // When
        String result = AlphabetWarAirstrike.alphabetWar(input);

        // Then
        assertThat(result)
                .isEqualTo("Left side wins!");
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "****",
            "z*dq*mw*pb*s",
            "zdqmwpbs"
    })
    void alphabetWar_whenDraw_returnCorrectString(
            // Given
            String input
    ) {

        // When
        String result = AlphabetWarAirstrike.alphabetWar(input);

        // Then
        assertThat(result)
                .isEqualTo("Let's fight again!");
    }
}
