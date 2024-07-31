package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RemoveOutermostParenthesesTest {

    private final RemoveOutermostParentheses.Solution subject = new RemoveOutermostParentheses.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments("(()())(())", "()()()"),
                Arguments.arguments("(()())(())(()(()))", "()()()()(())"),
                Arguments.arguments("()()", "")
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void removeOuterParentheses(
            // Given
            String input,
            String expected) {

        // When
        String result = subject.removeOuterParentheses(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}