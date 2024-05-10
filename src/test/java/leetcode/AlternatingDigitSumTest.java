package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class AlternatingDigitSumTest {

    private final AlternatingDigitSum.Solution subject = new AlternatingDigitSum.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments(521, 4),
                Arguments.arguments(111, 1),
                Arguments.arguments(886996, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void alternateDigitSum(
            // Given
            int input,
            int expected) {

        // When
        int result = subject.alternateDigitSum(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}