package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SortAnArrayTest {

    private final SortAnArray.Solution subject = new SortAnArray.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments(new int[]{5, 2, 3, 1}, new int[]{1, 2, 3, 5}),
                Arguments.arguments(new int[]{5, 1, 1, 2, 0, 0}, new int[]{0, 0, 1, 1, 2, 5})
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void sortArray(
            // Given
            int[] input,
            int[] expected) {

        // When
        int[] result = subject.sortArray(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}