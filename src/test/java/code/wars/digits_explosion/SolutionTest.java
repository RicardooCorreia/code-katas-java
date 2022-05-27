package code.wars.digits_explosion;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void explode_explodeNumbers() {

        // Given
        final String input = "102269";

        // When
        final String result = Solution.explode(input);

        // Then
        assertThat(result)
                .isEqualTo("12222666666999999999");
    }

    @Test
    void explode_whenZero_returnEmpty() {

        // Given
        final String input = "00";

        // When
        final String result = Solution.explode(input);

        // Then
        assertThat(result)
                .isEqualTo("");
    }
}
