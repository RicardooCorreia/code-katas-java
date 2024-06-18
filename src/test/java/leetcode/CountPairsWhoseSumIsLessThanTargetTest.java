package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CountPairsWhoseSumIsLessThanTargetTest {

    private final CountPairsWhoseSumIsLessThanTarget.Solution subject = new CountPairsWhoseSumIsLessThanTarget.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments(List.of(-1, 1, 2, 3, 1), 2, 3),
                Arguments.arguments(List.of(-6, 2, 5, -2, -7, -1, 3), -2, 10)
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void countPairs(
            // Given
            List<Integer> input, int target, int expected) {

        // When
        int result = subject.countPairs(input, target);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}