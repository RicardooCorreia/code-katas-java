package code.wars.simple_consecutive_pairs;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static code.wars.simple_consecutive_pairs.Solution.solve;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SolutionTest {

    static Stream<Arguments> testScenarios() {
        return Stream.of(
                arguments(new int[]{1, 2, 5, 8, -4, -3, 7, 6, 5}, 3),
                arguments(new int[]{21, 20, 22, 40, 39, -56, 30, -55, 95, 94}, 2),
                arguments(new int[]{81, 44, 80, 26, 12, 27, -34, 37, -35}, 0),
                arguments(new int[]{-55, -56, -7, -6, 56, 55, 63, 62}, 4)
        );
    }

    @ParameterizedTest(name = "numbers={0} -> {1}")
    @MethodSource("testScenarios")
    void counts_consecutive_pairs(
        // given
        int[] numbers, int expected) {

        // when
        var result = solve(numbers);

        // then
        assertThat(result).isEqualTo(expected);
    }
}