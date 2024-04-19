package code.wars.roman_numerals_encoder;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ConversionTest {

    private Conversion subjet = new Conversion();

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                Arguments.arguments(1, "I"),
                Arguments.arguments(2, "II"),
                Arguments.arguments(3, "III"),
                Arguments.arguments(4, "IV"),
                Arguments.arguments(5, "V"),
                Arguments.arguments(6, "VI"),
                Arguments.arguments(7, "VII"),
                Arguments.arguments(8, "VIII"),
                Arguments.arguments(9, "IX"),
                Arguments.arguments(10, "X")
        );
    }

    public static Stream<Arguments> complexTests() {

        return Stream.of(
                Arguments.arguments(1990, "MCMXC"),
                Arguments.arguments(2008, "MMVIII"),
                Arguments.arguments(1666, "MDCLXVI")
        );
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    public void solution_returnCorrectNumber(
            // Given
            int input,
            String expeccted) {

        // When
        final String result = subjet.solution(input);

        // Then
        assertThat(result)
                .isEqualTo(expeccted);
    }

    @ParameterizedTest
    @MethodSource("complexTests")
    public void solution_whenComplexNumbers_returnCorrectNumber(
            // Given
            int input,
            String expeccted) {

        // When
        final String result = subjet.solution(input);

        // Then
        assertThat(result)
                .isEqualTo(expeccted);
    }
}
