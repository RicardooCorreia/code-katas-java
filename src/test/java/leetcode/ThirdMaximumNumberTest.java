package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ThirdMaximumNumberTest {

    private final ThirdMaximumNumber.Solution subject = new ThirdMaximumNumber.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments(new int[]{3, 2, 1}, 1),
                Arguments.arguments(new int[]{1, 2}, 2),
                Arguments.arguments(new int[]{2, 2, 3, 1}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void thirdMax(
            // Given
            int[] input,
            int expected) {

        // When
        int result = subject.thirdMax(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}