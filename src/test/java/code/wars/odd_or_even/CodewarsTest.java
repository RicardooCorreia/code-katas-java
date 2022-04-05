package code.wars.odd_or_even;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CodewarsTest {

    @Test
    public void oddOrEven() {
        // Given
        final int[] input = {2, 5, 34, 6};

        // When
        final String result = Codewars.oddOrEven(input);

        // Then
        assertThat(result)
                .isEqualTo("odd");
    }
}
