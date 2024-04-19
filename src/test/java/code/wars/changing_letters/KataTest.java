package code.wars.changing_letters;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KataTest {

    @Test
    public void swap_baseTest1() {

        // Given
        String input = "HelloWorld!";

        // When
        String result = Kata.swap(input);

        // Then
        assertThat(result)
                .isEqualTo("HEllOWOrld!");
    }

    @Test
    public void swap_baseTest2() {

        // Given
        String input = "Sunday";

        // When
        String result = Kata.swap(input);

        // Then
        assertThat(result)
                .isEqualTo("SUndAy");
    }
}
