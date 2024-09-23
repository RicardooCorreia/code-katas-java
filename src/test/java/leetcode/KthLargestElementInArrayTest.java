package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class KthLargestElementInArrayTest {

    private final KthLargestElementInArray.Solution subject = new KthLargestElementInArray.Solution();

    public static Stream<Arguments> examples() {
        return Stream.of(
                Arguments.arguments(new int[]{3, 2, 1, 5, 6, 4}, 2, 5),
                Arguments.arguments(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void findKthLargest(
            // Given
            int[] nums,
            int k,
            int expected) {

        // When
        int result = subject.findKthLargest(nums, k);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}