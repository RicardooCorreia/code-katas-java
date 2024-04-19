package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RemoveElementTest {

    private final RemoveElement.Solution subject = new RemoveElement.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments(new int[]{3, 2, 2, 3}, 3, 2, new int[]{2, 2}),
                Arguments.arguments(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2, 5, new int[]{0, 1, 3, 0, 4})
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void removeElement(
            // Given
            int[] input,
            int toRemove,
            int newSize,
            int[] expectedInput) {

        // When
        int result = subject.removeElement(input, toRemove);

        // Then
        assertThat(result)
                .isEqualTo(newSize);
        assertThat(Arrays.copyOfRange(input, 0, newSize))
                .containsExactly(expectedInput);
    }
}