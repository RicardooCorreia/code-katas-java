package code.wars.alternate_capitalization;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                Arguments.arguments("abcdef", new String[]{"AbCdEf", "aBcDeF"}),
                Arguments.arguments("codewars", new String[]{"CoDeWaRs", "cOdEwArS"}),
                Arguments.arguments("abracadabra", new String[]{"AbRaCaDaBrA", "aBrAcAdAbRa"}),
                Arguments.arguments("codewarriors", new String[]{"CoDeWaRrIoRs", "cOdEwArRiOrS"})
        );
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    public void basicTests(
            // Given
            String input,
            String[] expected) {

        // When
        String[] result = Solution.capitalize(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}
