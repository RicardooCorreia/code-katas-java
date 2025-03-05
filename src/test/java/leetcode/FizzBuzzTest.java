package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FizzBuzzTest {

    private final FizzBuzz.Solution subject = new FizzBuzz.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments(3, List.of("1", "2", "Fizz")),
                Arguments.arguments(5, List.of("1", "2", "Fizz", "4", "Buzz")),
                Arguments.arguments(15, List.of("1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"))
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void fizzBuzz(
            // Given
            int n,
            List<String> expected) {

        // When
        List<String> result = subject.fizzBuzz(n);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}