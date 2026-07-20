package code.wars.if_you_can_read_this;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class KataTest {

    @ParameterizedTest
    @MethodSource("natoConversionCases")
    void should_returnNatoPhoneticSpelling_when_convertingString(String input, String expected) {
        // given - input from MethodSource

        // when
        var result = Kata.toNATO(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> natoConversionCases() {
        return Stream.of(
            Arguments.of("If you can read",
                "India Foxtrot Yankee Oscar Uniform Charlie Alfa November Romeo Echo Alfa Delta"),
            Arguments.of("Did not see that coming",
                "Delta India Delta November Oscar Tango Sierra Echo Echo Tango Hotel Alfa Tango Charlie Oscar Mike India November Golf"),
            Arguments.of("go for it!",
                "Golf Oscar Foxtrot Oscar Romeo India Tango !"),
            Arguments.of("the five boxing wizards jump quickly.",
                "Tango Hotel Echo Foxtrot India Victor Echo Bravo Oscar Xray India November Golf Whiskey India Zulu Alfa Romeo Delta Sierra Juliett Uniform Mike Papa Quebec Uniform India Charlie Kilo Lima Yankee ."),
            Arguments.of("PACK MY BOX WITH FIVE DOZEN LIQUOR JUGS?",
                "Papa Alfa Charlie Kilo Mike Yankee Bravo Oscar Xray Whiskey India Tango Hotel Foxtrot India Victor Echo Delta Oscar Zulu Echo November Lima India Quebec Uniform Oscar Romeo Juliett Uniform Golf Sierra ?"),
            Arguments.of("  p ? u . n  c t u  , a t i o n  ! ",
                "Papa ? Uniform . November Charlie Tango Uniform , Alfa Tango India Oscar November !")
        );
    }
}