package code.wars.kingdoms.the_curse_simplified;

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
                arguments("***lo w***d!", new String[]{"hello", "world"}, "hello world!"),
                arguments("c**l, w*ak!", new String[]{"hell", "cell", "week", "weak"}, "cell, weak!"),
                arguments("hell*, w***d!", new String[]{"hello", "hell", "word", "world"}, "hello, world!"),
                arguments("***", new String[]{"mel", "dell"}, "mel"),
                arguments("", new String[]{"hell", "weak"}, ""),
                arguments("****. ***,", new String[]{"aaa", "bbbb"}, "bbbb. aaa,")
        );
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    void translate_baseScenarios(
            // Given
            String phrase,
            String[] vocabulary,
            String expected) {

        // When
        final String result = Kata.translate(phrase, vocabulary);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }

    @Test
    void translate_whenEdgeCase_returnCorrectPhrase() {

        // Given
        String speech = "*ow ****v* **** ****u oq**y *t***. s*opq. qro***, q*x";
        String[] vocabulary = new String[]{"ooqqu", "ptqqq", "qqqovq", "qpqq", "qpx", "oqqqy", "qropoo", "sqopq", "qow"};

        // When
        final String result = Kata.translate(speech, vocabulary);

        // Then
        assertThat(result).isEqualTo("qow qqqovq qpqq ooqqu oqqqy ptqqq. sqopq. qropoo, qpx");
    }
}
