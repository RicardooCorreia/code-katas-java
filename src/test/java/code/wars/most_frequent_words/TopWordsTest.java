package code.wars.most_frequent_words;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class TopWordsTest {

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                arguments("a a a  b  c c  d d d d  e e e e e", List.of("e", "d", "a")),
                arguments("e e e e DDD ddd DdD: ddd ddd aa aA Aa, bb cc cC e e e", List.of("e", "ddd", "aa")),
                arguments("""
                        In a village of La Mancha, the name of which I have no desire to call to
                        mind, there lived not long since one of those gentlemen that keep a lance
                        in the lance-rack, an old buckler, a lean hack, and a greyhound for
                        coursing. An olla of rather more beef than mutton, a salad on most
                        nights, scraps on Saturdays, lentils on Fridays, and a pigeon or so extra
                        on Sundays, made away with three-quarters of his income.
                        """, List.of("a", "of", "on"))
        );
    }

    public static Stream<Arguments> punctuationScenarios() {

        return Stream.of(
                arguments("//wont won't won't", List.of("won't", "wont")),
                arguments("  , e   .. ", List.of("e")),
                arguments("  ...  ", List.of()),
                arguments("  '  ", List.of()),
                arguments("  '''  ", List.of()),
                arguments(" ''' ''' ''' ", List.of())
        );
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    void top3_whenNormalSentences_countWords(
            // Given
            String phrase,
            List<String> expected) {

        // When
        final List<String> result = TopWords.top3(phrase);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("punctuationScenarios")
    void top3_whenSentencesHaveManyPunctuation_ignorePunctuation(
            // Given
            String phrase,
            List<String> expected) {

        // When
        final List<String> result = TopWords.top3(phrase);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }

    @Test
    void top3_whenSameWordInDifferentCase_returnSameWord() {

        // Given
        final String phrase = "aaa AAA Aaa AAa BbB BBB Bbb CCC ccc";

        // When
        final List<String> result = TopWords.top3(phrase);

        // Then
        assertThat(result)
                .isEqualTo(List.of("aaa", "bbb", "ccc"));
    }
}