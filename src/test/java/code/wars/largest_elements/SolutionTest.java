package code.wars.largest_elements;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @ParameterizedTest
    @MethodSource("largestElementsCases")
    void should_returnNLargestElementsSortedAscending_when_givenArray(int n, int[] arr, int[] expected) {
        // given
        // input from MethodSource

        // when
        var result = Solution.largest(n, arr);

        // then
        assertThat(result).containsExactly(expected);
    }

    private static Stream<Arguments> largestElementsCases() {
        return Stream.of(
                Arguments.of(1, new int[]{1, 2, 3, 4, 5}, new int[]{5}),
                Arguments.of(2, new int[]{1, 2, 3, 4, 5, 6}, new int[]{5, 6}),
                Arguments.of(4, new int[]{3, 4, 5, 6, 7}, new int[]{4, 5, 6, 7}),
                Arguments.of(3, new int[]{1, 2, 1, 1}, new int[]{1, 1, 2}),
                Arguments.of(5, new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5}),
                Arguments.of(0, new int[]{7, 6, 8}, new int[]{})
        );
    }
}