package code.wars.simple_prime_streaming;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SimplePrimeStreamingTest {

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                arguments(2, 2, "57"),
                arguments(10, 3, "192"),
                arguments(20, 9, "414347535"),
                arguments(30, 12, "616771737983"),
                arguments(40, 8, "83899710"),
                arguments(50, 6, "031071"),
                arguments(10000, 5, "02192"),
                arguments(20000, 5, "09334")
        );
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    void solve_baseTests(
            // Given
            int a,
            int b,
            String expected) {

        // When
        String result = SimplePrimeStreaming.solve(a, b);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}
