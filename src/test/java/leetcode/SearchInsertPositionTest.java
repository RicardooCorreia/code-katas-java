package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SearchInsertPositionTest {

    private final SearchInsertPosition.Solution subject = new SearchInsertPosition.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                arguments(new int[]{1, 3, 5, 6}, 5, 2),
                arguments(new int[]{1, 3, 5, 6}, 2, 1),
                arguments(new int[]{1, 3, 5, 6}, 7, 4),
                arguments(new int[]{1, 4, 6, 7, 8, 9}, 6, 2),
                arguments(new int[]{1}, 2, 1),
                arguments(new int[]{1}, 0, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void searchInsert(
            // Given
            int[] nums,
            int target,
            int expected) {

        // When
        int result = subject.searchInsert(nums, target);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}