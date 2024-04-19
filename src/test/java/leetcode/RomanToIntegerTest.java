package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RomanToIntegerTest {

    private final RomanToInteger.Solution subject = new RomanToInteger.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments("III", 3),
                Arguments.arguments("LVIII", 58),
                Arguments.arguments("MCMXCIV", 1994)
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void romanToInt(
            // Given
            String input,
            int expected) {

        // When
        int result = subject.romanToInt(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}