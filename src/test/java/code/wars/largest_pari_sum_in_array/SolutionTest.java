package code.wars.largest_pari_sum_in_array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @ParameterizedTest
    @MethodSource("largestPairSumCases")
    void should_returnLargestPairSum_when_summingTwoLargestNumbers(
        // given
        int[] numbers, int expectedSum) {

        // when
        int result = Solution.largestPairSum(numbers);

        // then
        assertThat(result).isEqualTo(expectedSum);
    }

    private static Stream<Arguments> largestPairSumCases() {
        return Stream.of(
            Arguments.of(new int[]{10, 14, 2, 23, 19}, 42),
            Arguments.of(new int[]{-100, -29, -24, -19, 19}, 0),
            Arguments.of(new int[]{1, 2, 3, 4, 6, -1, 2}, 10),
            Arguments.of(new int[]{-10, -8, -16, -18, -19}, -18));
    }
}
