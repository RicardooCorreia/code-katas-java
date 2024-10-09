package leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MinimumAddToMakeParenthesesValidTest {

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments("())", 1),
                Arguments.arguments("(((", 3)
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void minAddToMakeValid_examples(
            // Given
            String input, int expected) {

        // When
        int result = new MinimumAddToMakeParenthesesValid.Solution().minAddToMakeValid(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }

    @Test
    void minAddToMakeValid_whenAlreadyValid_return0() {

        // Given
        String input = "()";

        // When
        int result = new MinimumAddToMakeParenthesesValid.Solution().minAddToMakeValid(input);

        // Then
        assertThat(result)
                .isEqualTo(0);
    }

    @Test
    void minAddToMakeValid_whenIsComplexExample_returnCorrectResult() {

        // Given
        String input = "()))((";

        // When
        int result = new MinimumAddToMakeParenthesesValid.Solution().minAddToMakeValid(input);

        // Then
        assertThat(result)
                .isEqualTo(4);
    }
}