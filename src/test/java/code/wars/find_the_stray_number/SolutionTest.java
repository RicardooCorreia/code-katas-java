package code.wars.find_the_stray_number;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    public void stray() {

        // Given
        final int[] input = {1, 1, 2};

        // When
        final int result = Solution.stray(input);

        // Then
        assertThat(result)
                .isEqualTo(2);
    }
}
