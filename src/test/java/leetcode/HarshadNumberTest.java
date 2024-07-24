package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class HarshadNumberTest {

    private final HarshadNumber.Solution subject = new HarshadNumber.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments(18, 9),
                Arguments.arguments(23, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void sumOfTheDigitsOfHarshadNumber(
            // Given
            int input,
            int expected) {

        // When
        int result = subject.sumOfTheDigitsOfHarshadNumber(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}