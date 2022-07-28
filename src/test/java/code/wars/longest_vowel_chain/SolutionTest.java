package code.wars.longest_vowel_chain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SolutionTest {

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                arguments("ultrarevolutionariees", 3),
                arguments("codewarriors", 2),
                arguments("suoidea", 3),
                arguments("strengthlessnesses", 1),
                arguments("mnopqriouaeiopqrstuvwxyuaeiouaeiou", 11)
        );
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    public void solve_baseTests(
            // Given
            String input,
            int expected) {

        // When
        final int result = Solution.solve(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}
