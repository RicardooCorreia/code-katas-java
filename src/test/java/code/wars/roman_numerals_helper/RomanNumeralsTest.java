package code.wars.roman_numerals_helper;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RomanNumeralsTest {

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                Arguments.arguments(1, "I"),
                Arguments.arguments(4, "IV"),
                Arguments.arguments(5, "V"),
                Arguments.arguments(6, "VI"),
                Arguments.arguments(8, "VIII"),
                Arguments.arguments(9, "IX"),
                Arguments.arguments(10, "X"),
                Arguments.arguments(3999, "MMMCMXCIX"),
                Arguments.arguments(1990, "MCMXC"),
                Arguments.arguments(2008, "MMVIII"),
                Arguments.arguments(1666, "MDCLXVI")
        );
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    public void toRoman_baseTests(
            // Given
            int input,
            String expected) {

        // When
        String result = RomanNumerals.toRoman(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    public void fromRoman_baseTests(
            // Given
            int expected,
            String input) {

        // When
        int result = RomanNumerals.fromRoman(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}
