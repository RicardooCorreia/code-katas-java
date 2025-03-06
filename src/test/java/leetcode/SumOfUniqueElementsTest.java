package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SumOfUniqueElementsTest {

    private final SumOfUniqueElements.Solution subject = new SumOfUniqueElements.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments(new int[]{1, 2, 3, 2}, 4),
                Arguments.arguments(new int[]{1, 1, 1, 1}, 0),
                Arguments.arguments(new int[]{1, 2, 3, 4, 5}, 15)
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void sumOfUnique(
            // Given
            int[] input,
            int expected) {

        // When
        int result = subject.sumOfUnique(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}