package code.wars.catch_the_bus;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static code.wars.catch_the_bus.CatchBus.catchTheBus;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.data.Offset.offset;

class CatchBusTest {

    @Nested
    class RegularTests {
        @ParameterizedTest
        @MethodSource("regularCases")
        void should_returnCorrectProbability_when_boyCanCatchBus(String[] busTimes, String[] boyTimes, double expected) {
            // given
            // busTimes, boyTimes, and expected from MethodSource

            // when
            double result = catchTheBus(busTimes, boyTimes);

            // then
            assertThat(result).isCloseTo(expected, offset(0.001));
        }

        private static Stream<Arguments> regularCases() {
            return Stream.of(
                    Arguments.of(new String[]{"4:53 PM", "5:00 PM"}, new String[]{"4:47 PM", "4:55 PM"}, 3.571),
                    Arguments.of(new String[]{"7:58 AM", "8:02 AM"}, new String[]{"7:55 AM", "8:01 AM"}, 18.75),
                    Arguments.of(new String[]{"12:00 PM", "12:12 PM"}, new String[]{"11:59 AM", "12:11 PM"}, 42.013),
                    Arguments.of(new String[]{"11:35 AM", "12:02 PM"}, new String[]{"11:45 AM", "11:51 AM"}, 48.148),
                    Arguments.of(new String[]{"6:22 PM", "6:23 PM"}, new String[]{"6:21 PM", "6:25 PM"}, 62.5),
                    Arguments.of(new String[]{"12:58 PM", "1:02 PM"}, new String[]{"1:00 PM", "1:06 PM"}, 91.667)
            );
        }
    }

    @Nested
    class EdgeTests {
        @ParameterizedTest
        @MethodSource("edgeCases")
        void should_returnCorrectProbability_when_boyAlwaysEarlyOrAlwaysLate(String[] busTimes, String[] boyTimes, double expected) {
            // given
            // busTimes, boyTimes, and expected from MethodSource

            // when
            double result = catchTheBus(busTimes, boyTimes);

            // then
            assertThat(result).isCloseTo(expected, offset(0.001));
        }

        private static Stream<Arguments> edgeCases() {
            return Stream.of(
                    Arguments.of(new String[]{"4:53 PM", "5:00 PM"}, new String[]{"4:47 PM", "4:52 PM"}, 0.0),
                    Arguments.of(new String[]{"9:22 AM", "9:23 AM"}, new String[]{"9:24 AM", "9:44 AM"}, 100.0)
            );
        }
    }
}
