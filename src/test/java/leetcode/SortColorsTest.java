package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SortColorsTest {

    private final SortColors.Solution subject = new SortColors.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments(new int[]{2, 0, 2, 1, 1, 0}, new int[]{0, 0, 1, 1, 2, 2}),
                Arguments.arguments(new int[]{2, 0, 1}, new int[]{0, 1, 2})
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void sortColors(
            // Given
            int[] nums,
            int[] expected) {

        // When
        subject.sortColors(nums);

        // Then
        assertThat(nums)
                .isEqualTo(expected);
    }
}