package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CountTheNumberOfConsistentStringsTest {

    private final CountTheNumberOfConsistentStrings.Solution subject = new CountTheNumberOfConsistentStrings.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                arguments(new String[]{"ad", "bd", "aaab", "baa", "badab"}, "ab", 2),
                arguments(new String[]{"a", "b", "c", "ab", "ac", "bc", "abc"}, "abc", 7),
                arguments(new String[]{"cc", "acd", "b", "ba", "bac", "bad", "ac", "d"}, "cad", 4)
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void countConsistentStrings(
            // Given
            String[] words,
            String allowed,
            int expected) {

        // When
        int result = subject.countConsistentStrings(allowed, words);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}