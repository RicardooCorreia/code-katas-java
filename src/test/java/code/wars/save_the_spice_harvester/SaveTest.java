package code.wars.save_the_spice_harvester;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static code.wars.save_the_spice_harvester.Save.harvesterRescue;
import static org.assertj.core.api.Assertions.assertThat;

class SaveTest {

    @ParameterizedTest
    @MethodSource("rescueCases")
    void should_rescueHarvester_when_carryallArrivesBeforeWorm(int[][] data) {
        // given
        // input from MethodSource

        // when
        var result = harvesterRescue(data);

        // then
        assertThat(result).isEqualTo("The spice must flow! Rescue the harvester!");
    }

    @ParameterizedTest
    @MethodSource("cannotRescueCases")
    void should_returnDamnTheSpice_when_wormArrivesBeforeCarryall(int[][] data) {
        // given
        // input from MethodSource

        // when
        var result = harvesterRescue(data);

        // then
        assertThat(result).isEqualTo("Damn the spice! I'll rescue the miners!");
    }

    private static Stream<Arguments> rescueCases() {
        return Stream.of(
                Arguments.of((Object) new int[][]{{345, 600}, {200, 100, 25}, {350, 200, 32}}),
                Arguments.of((Object) new int[][]{{0, 0}, {100, 0, 1}, {10, 0, 100}}),
                Arguments.of((Object) new int[][]{{-100, -200}, {-300, -400, 50}, {-150, -100, 60}})
        );
    }

    private static Stream<Arguments> cannotRescueCases() {
        return Stream.of(
                Arguments.of((Object) new int[][]{{0, 0}, {10, 0, 100}, {100, 0, 1}}),
                Arguments.of((Object) new int[][]{{0, 0}, {10, 0, 5}, {1, 0, 1}}),
                Arguments.of((Object) new int[][]{{0, 0}, {50, 0, 10}, {10, 0, 1}})
        );
    }
}
