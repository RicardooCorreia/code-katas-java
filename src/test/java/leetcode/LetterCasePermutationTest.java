package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LetterCasePermutationTest {

    private final LetterCasePermutation.Solution subject = new LetterCasePermutation.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments("a1b2", List.of("a1b2", "a1B2", "A1b2", "A1B2")),
                Arguments.arguments("3z4", List.of("3z4", "3Z4"))
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void letterCasePermutation(
            // Given
            String input,
            List<String> expected) {

        // When
        List<String> result = subject.letterCasePermutation(input);

        // Then
        assertThat(result)
                .containsExactlyInAnyOrder(expected.toArray(new String[0]));
    }
}