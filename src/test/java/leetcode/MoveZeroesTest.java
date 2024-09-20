package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MoveZeroesTest {

    @Test
    void moveZeroes() {

        // Given
        int[] nums = {0, 1, 0, 3, 12};
        MoveZeroes.Solution subject = new MoveZeroes.Solution();

        // When
        subject.moveZeroes(nums);

        // Then
        assertThat(nums)
                .isEqualTo(new int[]{1, 3, 12, 0, 0});
    }
}