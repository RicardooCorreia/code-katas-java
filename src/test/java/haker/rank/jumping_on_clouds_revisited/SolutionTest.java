package haker.rank.jumping_on_clouds_revisited;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void jumpOnClouds_whenLandsOnAChargeCloud_loseExtraEnergy() {

        // Given
        final int[] clouds = {0, 0, 1, 0};
        final int jumpSize = 2;

        // When
        final int result = Solution.jumpingOnClouds(clouds, jumpSize);

        // Then
        assertThat(result)
                .isEqualTo(96);
    }

    @Test
    void jumpOnClouds_whenIsALongerCase_returnCorrectEnergy() {

        // Given
        final int[] clouds = {0, 0, 1, 0, 0, 1, 1, 0};
        final int jumpSize = 2;

        // When
        final int result = Solution.jumpingOnClouds(clouds, jumpSize);

        // Then
        assertThat(result)
                .isEqualTo(92);
    }
}