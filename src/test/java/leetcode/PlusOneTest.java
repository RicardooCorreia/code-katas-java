package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PlusOneTest {

    private final PlusOne.Solution subject = new PlusOne.Solution();

    public static Stream<Arguments> examples() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 2, 3}, new int[]{1, 2, 4}),
                Arguments.arguments(new int[]{4, 3, 2, 1}, new int[]{4, 3, 2, 2}),
                Arguments.arguments(new int[]{0}, new int[]{1}),
                Arguments.arguments(new int[]{9}, new int[]{1, 0}),
                Arguments.arguments(new int[]{9, 9, 9}, new int[]{1, 0, 0, 0}),
                Arguments.arguments(new int[]{1, 8, 9, 9}, new int[]{1, 9, 0, 0})

        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void plusOne(
            // Given
            int[] input,
            int[] expected) {

        // When
        int[] result = subject.plusOne(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}