package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CheckIfWordEqualsSummationOfTwoWordsTest {

    private final CheckIfWordEqualsSummationOfTwoWords.Solution subject = new CheckIfWordEqualsSummationOfTwoWords.Solution();

    public static Stream<Arguments> examples() {
        return Stream.of(
                Arguments.arguments("acb", "cba", "cdb", true),
                Arguments.arguments("aaaa", "aa", "aaab", false),
                Arguments.arguments("a", "aa", "aaaa", true)
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void isSumEqual(
            // Given
            String word1,
            String word2,
            String target,
            boolean expected) {

        // When
        boolean result = subject.isSumEqual(word1, word2, target);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}