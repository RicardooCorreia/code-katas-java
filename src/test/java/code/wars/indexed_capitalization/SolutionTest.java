package code.wars.indexed_capitalization;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static code.wars.indexed_capitalization.Solution.capitalize;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SolutionTest {

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                arguments("abcdef", new int[]{1, 2, 5}, "aBCdeF"),
                arguments("abcdef", new int[]{1, 2, 5, 100}, "aBCdeF"),
                arguments("codewars", new int[]{1, 3, 5, 50}, "cOdEwArs"),
                arguments("abracadabra", new int[]{2, 6, 9, 10}, "abRacaDabRA"),
                arguments("codewarriors", new int[]{5}, "codewArriors")
        );
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    public void capitalize_baseTests(
            // Given
            String input,
            int[] index,
            String expected) {

        // When
        String result = capitalize(input, index);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}
