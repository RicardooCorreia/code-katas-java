package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MissingNumberTest {

    private final MissingNumber.Solution subject = new MissingNumber.Solution();

    public static Stream<Arguments> examples() {
        return Stream.of(
                Arguments.arguments(new int[]{3, 0, 1}, 2),
                Arguments.arguments(new int[]{0, 1}, 2),
                Arguments.arguments(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}, 8));
    }

    @ParameterizedTest
    @MethodSource("examples")
    void missingNumber(
            // Given
            int[] input,
            int expected) {

        // When
        int result = subject.missingNumber(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}