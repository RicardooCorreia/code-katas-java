package code.wars.character_with_longest_consecutive_repetition;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SolutionTest {

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                arguments("aaaabb", new Object[]{"a", 4}),
                arguments("bbbaaabaaaa", new Object[]{"a", 4}),
                arguments("cbdeuuu900", new Object[]{"u", 3}),
                arguments("abbbbb", new Object[]{"b", 5}),
                arguments("aabb", new Object[]{"a", 2})
        );
    }

    @Test
    public void longestRepetition_whenEmtpy_returnEmpty() {

        // Given
        String input = "";

        // When
        Object[] result = Solution.longestRepetition(input);

        // Then
        assertThat(result)
                .isEqualTo(new Object[]{"", 0});
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    void longestRepetition_baseScenarios(
            // Given
            String input,
            Object[] expected) {

        // When
        Object[] result = Solution.longestRepetition(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}
