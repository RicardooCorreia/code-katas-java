package code.wars.disemvowel_trolls;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class TrollTest {

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                arguments("This website is for losers LOL!", "Ths wbst s fr lsrs LL!"),
                arguments("No offense but,\nYour writing is among the worst I've ever read", "N ffns bt,\nYr wrtng s mng th wrst 'v vr rd"),
                arguments("What are you, a communist?", "Wht r y,  cmmnst?")
        );
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    public void disemvowel_removeVowelsFromString(
            // Given
            String input,
            String expected) {

        // When
        final String result = Troll.disemvowel(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    public void disemvowelRegex_removeVowelsFromString(
            // Given
            String input,
            String expected) {

        // When
        final String result = Troll.disemvowelRegex(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}
