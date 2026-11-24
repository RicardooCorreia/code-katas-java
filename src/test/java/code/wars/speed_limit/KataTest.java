package code.wars.speed_limit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class KataTest {

    public static Stream<Arguments> sampleCases() {

        return Stream.of(
                Arguments.arguments(60, new int[]{80, 70, 60}, 0),
                Arguments.arguments(90, new int[]{80}, 100),
                Arguments.arguments(100, new int[]{110, 100, 80}, 250),
                Arguments.arguments(130, new int[]{140, 130, 100}, 500),
                Arguments.arguments(110, new int[]{120, 110, 100}, 100),
                Arguments.arguments(220, new int[]{120, 110, 100}, 1500),
                Arguments.arguments(100, new int[]{70, 80, 90, 100}, 850)
        );
    }

    public static Stream<Arguments> fineBoundaries() {

        return Stream.of(
                Arguments.arguments(59, 0),
                Arguments.arguments(60, 0),
                Arguments.arguments(69, 0),
                Arguments.arguments(70, 100),
                Arguments.arguments(79, 100),
                Arguments.arguments(80, 250),
                Arguments.arguments(89, 250),
                Arguments.arguments(90, 500),
                Arguments.arguments(200, 500)
        );
    }

    @ParameterizedTest
    @MethodSource("sampleCases")
    void should_return_total_fine_when_passing_sample_signals(
            // given
            int speed,
            int[] signals,
            int expectedFine) {

        // when
        int result = Kata.speedLimit(speed, signals);

        // then
        assertThat(result).isEqualTo(expectedFine);
    }

    @ParameterizedTest
    @MethodSource("fineBoundaries")
    void should_return_fine_for_speed_band_when_passing_a_single_signal_of_60(
            // given
            int speed,
            int expectedFine) {

        // when
        int result = Kata.speedLimit(speed, new int[]{60});

        // then
        assertThat(result).isEqualTo(expectedFine);
    }

    @Test
    void should_return_zero_when_no_signals_exist() {
        // given
        int speed = 200;
        int[] signals = {};

        // when
        int result = Kata.speedLimit(speed, signals);

        // then
        assertThat(result).isZero();
    }
}
