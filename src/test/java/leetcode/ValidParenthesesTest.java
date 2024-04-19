package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidParenthesesTest {

    private final ValidParentheses.Solution subject = new ValidParentheses.Solution();

    public static Stream<Arguments> validExamples() {

        return Stream.of(
                Arguments.arguments("()"),
                Arguments.arguments("()[]{}"),
                Arguments.arguments("([{}])")
        );
    }

    public static Stream<Arguments> invalidExamples() {

        return Stream.of(
                Arguments.arguments("(("),
                Arguments.arguments("(]"),
                Arguments.arguments("]"),
                Arguments.arguments("([{]})")
        );
    }

    @ParameterizedTest
    @MethodSource("validExamples")
    void isValid_validExamples(
            // Given
            String input) {

        // When
        boolean result = subject.isValid(input);

        // Then
        assertTrue(result);
    }

    @ParameterizedTest
    @MethodSource("invalidExamples")
    void isValid_invalidExamples(
            // Given
            String input) {

        // When
        boolean result = subject.isValid(input);

        // Then
        assertFalse(result);
    }
}