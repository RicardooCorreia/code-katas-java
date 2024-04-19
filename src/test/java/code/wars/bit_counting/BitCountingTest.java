package code.wars.bit_counting;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BitCountingTest {

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                arguments(1234, 5),
                arguments(4, 1),
                arguments(7, 3),
                arguments(9, 2),
                arguments(10, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    public void countBits_baseTests(
            // Given
            int input,
            int expected) {

        // When
        final int result = BitCounting.countBits(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}
