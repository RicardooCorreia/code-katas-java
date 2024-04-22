package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MergeSortedArrayTest {

    private final MergeSortedArray.Solution subject = new MergeSortedArray.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3, new int[]{1, 2, 2, 3, 5, 6}),
                Arguments.arguments(new int[]{1}, 1, new int[]{}, 0, new int[]{1}),
                Arguments.arguments(new int[]{0}, 0, new int[]{1}, 1, new int[]{1}),
                Arguments.arguments(new int[]{2,0}, 1, new int[]{1}, 1, new int[]{1, 2})
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void merge(
            // Given
            int[] nums1,
            int num1Length,
            int[] nums2,
            int num2Length,
            int[] expected) {

        // When
        subject.merge(nums1, num1Length, nums2, num2Length);

        // Then
        assertThat(nums1)
                .isEqualTo(expected);
    }
}