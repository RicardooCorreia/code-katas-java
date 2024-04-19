package code.wars.triangular_treasure;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TriangularTest {

    @Test
    public void triangular_whenSmallNumbers_findCorrectValue() {

        // Given
        final int input = 2;

        // When
        final long result = Triangular.triangular(input);

        // Then
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void triangular_whenLargeNumber_findCorrectValue() {

        // Given
        final int input = 1275;

        // When
        final long result = Triangular.triangular(input);

        // Then
        assertThat(result).isEqualTo(813450);
    }

    @Test
    public void triangular_whenVeryLargeNumber_findCorrectValue() {

        // Given
        final int input = 772736245;

        // When
        final long result = Triangular.triangular(input);

        // Then
        assertThat(result).isEqualTo(298560652554718135L);
    }

    @Test
    public void triangular_whenZero_returnZero() {

        // Given
        final int input = 0;

        // When
        final long result = Triangular.triangular(input);

        // Then
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void triangular_whenNegative_returnZero() {

        // Given
        final int input = -10;

        // When
        final long result = Triangular.triangular(input);

        // Then
        assertThat(result).isEqualTo(0);
    }
}
