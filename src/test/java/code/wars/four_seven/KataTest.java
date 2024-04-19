package code.wars.four_seven;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KataTest {

    @Test
    public void fourSeven_when4_return7() {

        // Given
        final int input = 4;

        // When
        final int result = Kata.fourSeven(input);

        // Then
        assertThat(result)
                .isEqualTo(7);
    }

    @Test
    public void fourSeven_when7_return4() {

        // Given
        final int input = 7;

        // When
        final int result = Kata.fourSeven(input);

        // Then
        assertThat(result)
                .isEqualTo(4);
    }

    @Test
    public void fourSeven_whenOtherNumber_return0() {

        // Given
        final int input = 123;

        // When
        final int result = Kata.fourSeven(input);

        // Then
        assertThat(result)
                .isEqualTo(0);
    }
}
