package code.wars.will_there_be_enough_space;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BobTest {

    public static Stream<Arguments> baseScenarios() {
        return Stream.of(
                arguments(10, 5, 5, 0),
                arguments(100, 60, 50, 10),
                arguments(20, 5, 5, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    public void enough_baseTests(
            // Given
            int cap,
            int on,
            int wait,
            int expected) {

        // When
        final int result = Bob.enough(cap, on, wait);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}
