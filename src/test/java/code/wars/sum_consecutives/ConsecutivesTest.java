package code.wars.sum_consecutives;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class ConsecutivesTest {

    @ParameterizedTest
    @MethodSource("inputsAndExpectedOutputs")
    void should_sumConsecutiveDuplicates_when_listContainsRuns(List<Integer> input, List<Integer> expected) {
        // given - input from MethodSource

        // when
        List<Integer> result = Consecutives.sumConsecutives(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> inputsAndExpectedOutputs() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 4, 4, 4, 0, 4, 3, 3, 1), Arrays.asList(1, 12, 0, 4, 6, 1)),
                Arguments.of(Arrays.asList(-5, -5, 7, 7, 12, 0), Arrays.asList(-10, 14, 12, 0)));
    }
}