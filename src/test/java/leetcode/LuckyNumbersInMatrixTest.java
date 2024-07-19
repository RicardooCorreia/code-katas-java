package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LuckyNumbersInMatrixTest {

    private final LuckyNumbersInMatrix.Solution subject = new LuckyNumbersInMatrix.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                arguments(new int[][]{new int[]{1, 10, 4, 2}, new int[]{9, 3, 8, 7}, new int[]{15, 16, 17, 12}}, List.of(12)),
                arguments(new int[][]{new int[]{7, 8}, new int[]{1, 2}}, List.of(7))
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void luckyNumbers(
            // Given
            int[][] input,
            List<Integer> expected) {

        // When
        List<Integer> result = subject.luckyNumbers(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}