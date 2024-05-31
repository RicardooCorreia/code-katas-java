package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SingleNumberIIITest {

    private final SingleNumberIII.Solution subject = new SingleNumberIII.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments(new int[]{1, 2, 1, 3, 2, 5}, new int[]{3, 5}),
                Arguments.arguments(new int[]{-1, 0}, new int[]{-1, 0}),
                Arguments.arguments(new int[]{1, 0}, new int[]{1, 0})
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void singleNumber(
            // Given
            int[] input,
            int[] expected) {

        // When
        int[] result = subject.singleNumber(input);

        // Then
        assertThat(result)
                .containsExactlyInAnyOrder(expected);
    }
}