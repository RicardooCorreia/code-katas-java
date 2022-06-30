package code.wars.simple_beads_count;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BeadsCounterTest {

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                arguments(0, 0),
                arguments(1, 0),
                arguments(3, 4),
                arguments(5, 8)
        );
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    public void countRedBeads_baseTests(
            // Given
            int input,
            int expected) {

        // When
        final int results = BeadsCounter.countRedBeads(input);

        // Then
        assertThat(results)
                .isEqualTo(expected);
    }
}
