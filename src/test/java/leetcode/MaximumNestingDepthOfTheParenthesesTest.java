package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Java6Assertions.assertThat;

class MaximumNestingDepthOfTheParenthesesTest {

    private final MaximumNestingDepthOfTheParentheses.Solution subject = new MaximumNestingDepthOfTheParentheses.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments("(1+(2*3)+((8)/4))+1", 3),
                Arguments.arguments("(1)+((2))+(((3)))", 3),
                Arguments.arguments("(1)+(2)+(3)", 1)
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void maxDepth(
            // Given
            String input,
            int expected) {

        // When
        int result = subject.maxDepth(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}