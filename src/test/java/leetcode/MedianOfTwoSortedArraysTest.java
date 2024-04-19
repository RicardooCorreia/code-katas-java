package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MedianOfTwoSortedArraysTest {

    private static final MedianOfTwoSortedArrays.Solution subject = new MedianOfTwoSortedArrays.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments(new int[]{1, 3}, new int[]{2}, 2),
                Arguments.arguments(new int[]{1, 2}, new int[]{3, 5}, 2.5)
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void findMedianSortedArrays_examples(
            // Given
            int[] array1,
            int[] array2,
            double expected) {

        // When
        double result = subject.findMedianSortedArrays(array1, array2);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}