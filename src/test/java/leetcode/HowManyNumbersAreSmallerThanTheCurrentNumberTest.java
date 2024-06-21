package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class HowManyNumbersAreSmallerThanTheCurrentNumberTest {

    private final HowManyNumbersAreSmallerThanTheCurrentNumber.Solution subject = new HowManyNumbersAreSmallerThanTheCurrentNumber.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments(new int[]{8, 1, 2, 2, 3}, new int[]{4, 0, 1, 1, 3}),
                Arguments.arguments(new int[]{6, 5, 4, 8}, new int[]{2, 1, 0, 3}),
                Arguments.arguments(new int[]{7, 7, 7, 7}, new int[]{0, 0, 0, 0})
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void smallerNumbersThanCurrent(
            // Given
            int[] input,
            int[] expected) {

        // When
        int[] result = subject.smallerNumbersThanCurrent(input);

        // Then
        assertThat(result)
                .containsExactly(expected);
    }
}