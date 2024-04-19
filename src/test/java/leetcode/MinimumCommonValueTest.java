package leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MinimumCommonValueTest {

    private final MinimumCommonValue.Solution subject = new MinimumCommonValue.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments(new int[]{1, 2, 3}, new int[]{2, 4}, 2),
                Arguments.arguments(new int[]{1, 2, 3, 6}, new int[]{2, 3, 4, 5}, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void getCommon(
            // Given
            int[] input1,
            int[] input2,
            int expected) {

        // When
        int result = subject.getCommon(input1, input2);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }

    @Test
    void getCommon_ifNoCommon_returnMinusOne() {

        // Given
        int[] input1 = new int[]{1, 2, 3, 4, 5};
        int[] input2 = new int[]{6, 7, 8, 9, 10};

        // When
        int result = subject.getCommon(input1, input2);

        // Then
        assertThat(result)
                .isEqualTo(-1);
    }
}