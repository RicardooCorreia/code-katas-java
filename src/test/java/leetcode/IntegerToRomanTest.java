package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class IntegerToRomanTest {

    private final IntegerToRoman.Solution subject = new IntegerToRoman.Solution();

    public static Stream<Arguments> examples() {
        return Stream.of(
                Arguments.arguments(3, "III"),
                Arguments.arguments(58, "LVIII"),
                Arguments.arguments(1994, "MCMXCIV")
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void intToRoman(
            // Given
            int input,
            String expected) {

        // When
        String result = subject.intToRoman(input);

        // Then
        Assertions.assertThat(result)
                .isEqualTo(expected);
    }
}