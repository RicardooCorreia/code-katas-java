package code.wars.unlucky_days;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class KataTest {

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                Arguments.arguments(2015, 3),
                Arguments.arguments(1986, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    public void unluckyDays_baseTests(
            // Given
            int input,
            int expected) {

        // When
        final int result = Kata.unluckyDays(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}
