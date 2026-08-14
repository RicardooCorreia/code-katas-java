package code.wars.sum_list_but_ignore_any_duplicates;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

    @ParameterizedTest
    @MethodSource("sumNoDuplicatesCases")
    void should_returnSumOfNonDuplicates_when_arrayContainsDuplicates(int[] input, int expected) {
        // given - input from MethodSource

        // when
        int result = Solution.sumNoDuplicates(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> sumNoDuplicatesCases() {
        return Stream.of(
            Arguments.of(new int[]{1, 1, 2, 3}, 5),
            Arguments.of(new int[]{1, 2, 3}, 6),
            Arguments.of(new int[]{1, 1, 2, 2, 3}, 3)
        );
    }
}