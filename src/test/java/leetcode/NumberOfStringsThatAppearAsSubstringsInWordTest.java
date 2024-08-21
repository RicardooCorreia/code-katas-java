package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class NumberOfStringsThatAppearAsSubstringsInWordTest {

    private final NumberOfStringsThatAppearAsSubstringsInWord.Solution subject
            = new NumberOfStringsThatAppearAsSubstringsInWord.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments(new String[]{"a", "abc", "bc", "d"}, "abc", 3),
                Arguments.arguments(new String[]{"a", "b", "c"}, "aaaaabbbbb", 2),
                Arguments.arguments(new String[]{"a", "a", "a"}, "ab", 3)
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void numOfStrings(
            // Given
            String[] input,
            String string,
            int expected) {

        // When
        int result = subject.numOfStrings(input, string);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}