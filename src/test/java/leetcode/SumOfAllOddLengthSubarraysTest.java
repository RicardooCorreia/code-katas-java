package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SumOfAllOddLengthSubarraysTest {

    private final SumOfAllOddLengthSubarrays.Solution subject = new SumOfAllOddLengthSubarrays.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments(new int[]{1, 4, 2, 5, 3}, 58),
                Arguments.arguments(new int[]{1, 2}, 3),
                Arguments.arguments(new int[]{10, 11, 12}, 66)
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void sumOddLengthSubarrays(
        // Given
        int[] input,
        int expected) {

        // When
        int result = subject.sumOddLengthSubarrays(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}