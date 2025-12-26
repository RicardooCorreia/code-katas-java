package code.wars.build_a_square;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KataTest {

    @Test
    void generateShape_examples() {

        // Given
        int input = 3;

        // When
        String result = Kata.generateShape(input);

        // Then
        assertThat(result)
                .isEqualTo("""
                        +++
                        +++
                        +++""");
    }
}
