package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ReversePrefixOfWordTest {

    private final ReversePrefixOfWord.Solution subject = new ReversePrefixOfWord.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments("abcdefd", 'd', "dcbaefd"),
                Arguments.arguments("xyxzxe", 'z', "zxyxxe"),
                Arguments.arguments("abcd", 'z', "abcd")
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void reversePrefix(
            // Given
            String input,
            char ch,
            String expected) {

        // When
        String result = subject.reversePrefix(input, ch);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}