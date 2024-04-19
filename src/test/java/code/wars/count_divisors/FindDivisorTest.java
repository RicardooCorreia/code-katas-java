package code.wars.count_divisors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FindDivisorTest {

    private final FindDivisor subject = new FindDivisor();

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                arguments(1, 1),
                arguments(4, 3),
                arguments(5, 2),
                arguments(12, 6),
                arguments(30, 8)
        );
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    public void numberOfDivisors_baseTests(
            // Given
            int number,
            int expected) {

        // When
        final long result = subject.numberOfDivisors(number);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }

    @Test
    public void numberOfDivisors_whenUpperLimit_returnCorrectResult() {

        // Given
        int number = 500000;

        // When
        final long result = subject.numberOfDivisors(number);

        // Then
        assertThat(result)
                .isEqualTo(42);
    }
}
