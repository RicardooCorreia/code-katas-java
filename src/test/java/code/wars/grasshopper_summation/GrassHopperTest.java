package code.wars.grasshopper_summation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class GrassHopperTest {

    public static Stream<Arguments> examples() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(2, 3),
                Arguments.of(4, 10),
                Arguments.of(6, 21),
                Arguments.of(8, 36)
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void summation_examples(
            // Given
            int n,
            int expected) {

        // When
        int result = GrassHopper.summation(n);

        // Then
        assertThat(result)
                .isEqualTo(expected);

    }
}
