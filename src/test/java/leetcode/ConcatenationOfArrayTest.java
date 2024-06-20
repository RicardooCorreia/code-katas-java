package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ConcatenationOfArrayTest {

    private final ConcatenationOfArray.Solution subject = new ConcatenationOfArray.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments(new int[]{1, 2, 1}, new int[]{1, 2, 1, 1, 2, 1}),
                Arguments.arguments(new int[]{1, 3, 2, 1}, new int[]{1, 3, 2, 1, 1, 3, 2, 1}),
                Arguments.arguments(new int[]{1}, new int[]{1, 1}),
                Arguments.arguments(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4, 1, 2, 3, 4})
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void getConcatenation(
            // Given
            int[] nums,
            int[] expected) {

        // When
        int[] result = subject.getConcatenation(nums);

        // Then
        assertThat(expected)
                .isEqualTo(result);
    }
}