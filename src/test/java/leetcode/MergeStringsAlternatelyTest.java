package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MergeStringsAlternatelyTest {

    private final MergeStringsAlternately.Solution subject = new MergeStringsAlternately.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
            Arguments.of("abc", "pqr", "apbqcr"),
            Arguments.of("ab", "pqrs", "apbqrs"),
            Arguments.of("abcd", "pq", "apbqcd")
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void mergeAlternately(
            // Given
            String word1,
            String word2,
            String expected) {

        // When
        String result = subject.mergeAlternately(word1, word2);

        // Then
        assertEquals(expected, result);
    }
}