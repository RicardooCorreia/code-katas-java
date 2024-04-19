package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SeparateTheDigitsInAnArrayTest {

    private final SeparateTheDigitsInAnArray.Solution subject = new SeparateTheDigitsInAnArray.Solution();

    public static Stream<Arguments> examples() {
        return Stream.of(
                Arguments.arguments(new int[]{13, 25, 83, 77}, new int[]{1, 3, 2, 5, 8, 3, 7, 7}),
                Arguments.arguments(new int[]{7, 1, 3, 9}, new int[]{7, 1, 3, 9})
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void separateDigits(
        // Given
            int[] input,
            int[] expected) {

        // When
        int[] result = subject.separateDigits(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}