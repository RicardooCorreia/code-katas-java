package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CheckIfTwoStringArraysAreEquivalentTest {

    private final CheckIfTwoStringArraysAreEquivalent.Solution subject = new CheckIfTwoStringArraysAreEquivalent.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments(new String[]{"ab", "c"}, new String[]{"a", "bc"}, true),
                Arguments.arguments(new String[]{"a", "cb"}, new String[]{"ab", "c"}, false),
                Arguments.arguments(new String[]{"abc", "d", "defg"}, new String[]{"abcddefg"}, true)
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void arrayStringsAreEqual(
            // Given
            String[] word1,
            String[] word2,
            boolean expected) {

        // When
        boolean result = subject.arrayStringsAreEqual(word1, word2);
        boolean result2 = subject.arrayStringsAreEqual2(word1, word2);

        // Then
        assertThat(result)
                .isEqualTo(expected)
                .isEqualTo(result2);
    }
}