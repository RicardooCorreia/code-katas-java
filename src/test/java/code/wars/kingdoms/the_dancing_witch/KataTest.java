package code.wars.kingdoms.the_dancing_witch;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class KataTest {

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                arguments(new String[]{"a b", " ba"}, "a"),
                arguments(new String[]{"ab kl", "ba kl", "a blk"}, "b"),
                arguments(new String[]{"icwth", "wicth", "witch"}, "w"),
                arguments(new String[]{"abcdef", "abcfde"}, "f"),
                arguments(new String[]{"a  b  c", "a b  c ", " ba   c"}, "a"),
                arguments(new String[]{"bc  x", " bcx ", " xbc "}, "x"),
                arguments(new String[]{"abcd", "cabd"}, "c"),
                arguments(new String[]{"xyz", "yxz", "zyx"}, "z"),
                arguments(new String[]{" x y z ", " xy  z ", "yx   z ", " xy  z "}, "y")
        );
    }

    public static Stream<Arguments> edgeScenarios() {

        return Stream.of(
                arguments(new String[]{"abdgefc", "adbegcf", "daebgfc", "adegfcb", "aedfgbc", "adegfcb", "dagecfb", "adegfcb", "adgefbc"},
                          "b"),
                arguments(new String[]{"dac   b ", "acd    b", "adc    b", "acd   b ", "ca d   b", "c ad  b ", "c ad  b ", " ca db  ", " ac bd  "},
                          "d"),
                arguments(new String[]{"cb feg da", "bcf ge ad", "cbfg ea d", "cfb gae d", "fcbga e d", "fbcag  ed", "bfac ged ", "baf cgde "},
                          null)
        );
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    void figureOut_baseTests(
            // Given
            String[] input,
            String expected) {

        // When
        String result = Kata.figureOut(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }

    @Test
    void figureOut_whenThereIsNoWitch_returnNull() {

        // Given
        String[] input = {"hop", "hpo", "pho"};

        // When
        String result = Kata.figureOut(input);

        // Then
        assertThat(result)
                .isNull();
    }

    @ParameterizedTest
    @MethodSource("edgeScenarios")
    void figureOut_edgeCases(
            // Given
            String[] input,
            String expected) {

        // When
        String result = Kata.figureOut(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}
