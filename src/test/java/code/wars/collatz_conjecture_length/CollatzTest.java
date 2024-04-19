package code.wars.collatz_conjecture_length;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CollatzTest {

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                arguments(100L, 26L),
                arguments(10L, 7L),
                arguments(500L, 111L),
                arguments(1000000000L, 101L),
                arguments(1000000000000000L, 276L)
        );
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    public void conjecture(
            // Given
            long input,
            long expected) {

        // When
        final long result = Collatz.conjecture(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}
