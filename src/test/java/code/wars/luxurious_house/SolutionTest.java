package code.wars.luxurious_house;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static code.wars.luxurious_house.Solution.luxhouse;
import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @ParameterizedTest(name = "[{index}]")
    @MethodSource("luxhouseCases")
    void should_returnCorrectFloors_when_calculatingLuxuriousAdditions(int[] houses, int[] expected) {
        // given
        // inputs from MethodSource

        // when
        var result = luxhouse(houses);

        // then
        assertThat(result).containsExactly(expected);
    }

    private static Stream<Arguments> luxhouseCases() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 1, 2}, new int[]{3, 2, 0, 2, 0}),
                Arguments.of(new int[]{3, 2, 1, 4}, new int[]{2, 3, 4, 0}),
                Arguments.of(new int[]{1, 2, 3}, new int[]{3, 2, 0}),
                Arguments.of(new int[]{3, 2, 1}, new int[]{0, 0, 0}),
                Arguments.of(new int[]{1, 1, 1}, new int[]{1, 1, 0})
        );
    }
}
