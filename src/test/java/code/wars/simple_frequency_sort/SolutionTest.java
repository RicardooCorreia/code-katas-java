package code.wars.simple_frequency_sort;

import static code.wars.simple_frequency_sort.Solution.sortByFrequency;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

    @ParameterizedTest
    @MethodSource("sortByFrequencyCases")
    void should_sortByFrequency_when_inputProvided(int[] input, int[] expected) {
        // given - input from MethodSource

        // when
        int[] result = sortByFrequency(input);

        // then
        assertThat(result)
            .containsExactly(expected);
    }

    private static Stream<Arguments> sortByFrequencyCases() {
        return Stream.of(
                Arguments.of(new int[]{2, 3, 5, 3, 7, 9, 5, 3, 7}, new int[]{3, 3, 3, 5, 5, 7, 7, 2, 9}),
                Arguments.of(new int[]{1, 2, 3, 0, 5, 0, 1, 6, 8, 8, 6, 9, 1}, new int[]{1, 1, 1, 0, 0, 6, 6, 8, 8, 2, 3, 5, 9}),
                Arguments.of(new int[]{5, 9, 6, 9, 6, 5, 9, 9, 4, 4}, new int[]{9, 9, 9, 9, 4, 4, 5, 5, 6, 6}),
                Arguments.of(new int[]{4, 4, 2, 5, 1, 1, 3, 3, 2, 8}, new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 8}),
                Arguments.of(new int[]{4, 9, 5, 0, 7, 3, 8, 4, 9, 0}, new int[]{0, 0, 4, 4, 9, 9, 3, 5, 7, 8})
        );
    }
}
