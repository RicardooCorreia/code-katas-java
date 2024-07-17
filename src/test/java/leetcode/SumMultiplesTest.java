package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SumMultiplesTest {

    private final SumMultiples.Solution subject = new SumMultiples.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments(7, 21),
                Arguments.arguments(10, 40),
                Arguments.arguments(9, 30)
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void sumOfMultiples(
            // Given
            int input,
            int expected) {

        // When
        int result = subject.sumOfMultiples(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}