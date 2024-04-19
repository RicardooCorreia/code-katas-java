package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class RemoveKDigitsTest {

    private final RemoveKDigits.Solution subject = new RemoveKDigits.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments("1432219", 3, "1219"),
                Arguments.arguments("10200", 1, "200"),
                Arguments.arguments("10", 2, "0")
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void removeKdigits(
        // Given
        String input,
        int k,
        String expected) {

        // When
        String result = subject.removeKdigits(input, k);
        String result2 = subject.removeKdigits2(input, k);

        // Then
        assertThat(result)
                .isEqualTo(expected)
                .isEqualTo(result2);
    }
}