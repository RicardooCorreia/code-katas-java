package code.wars.bouncing_balls;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BouncingBallTest {

    @Test
    public void bouncingBall_whenLowHeight_returnCorrectViewCount() {

        // Given
        final double floorNumber = 3.0;
        final double bounce = 0.66;
        final double window = 1.5;

        // When
        final int result = BouncingBall.bouncingBall(floorNumber, bounce, window);

        // Then
        assertThat(result)
                .isEqualTo(3);
    }

    @Test
    public void bouncingBall_whenHighHeight_returnCorrectViewCount() {

        // Given
        final double floorNumber = 30.0;
        final double bounce = 0.66;
        final double window = 1.5;

        // When
        final int result = BouncingBall.bouncingBall(floorNumber, bounce, window);

        // Then
        assertThat(result)
                .isEqualTo(15);
    }
}
