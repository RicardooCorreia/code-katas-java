package code.wars.is_a_triangle;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TriangleTesterTest {

    @Test
    public void isTriangle_whenCanBeTriangle_returnTrue() {

        // Given
        final int a = 1;
        final int b = 2;
        final int c = 2;

        // When
        final boolean result = TriangleTester.isTriangle(a, b, c);

        // Then
        assertThat(result)
                .isTrue();
    }

    @Test
    public void isTriangle_whenCanNotBeTriangle_returnFalse() {

        // Given
        final int a = 7;
        final int b = 2;
        final int c = 2;

        // When
        final boolean result = TriangleTester.isTriangle(a, b, c);

        // Then
        assertThat(result)
                .isFalse();
    }
}
