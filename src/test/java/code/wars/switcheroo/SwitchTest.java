package code.wars.switcheroo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SwitchTest {

    @Test
    public void switcheroo_whenHasInput_exchangeBAndA() {

        // Given
        final String input = "bac";

        // When
        final String result = Switch.switcheroo(input);

        // Then

        assertThat(result)
                .isEqualTo("abc");
    }

    @Test
    public void switcheroo_whenNoTrades_returnSameString() {

        // Given
        final String input = "ccc";

        // When
        final String result = Switch.switcheroo(input);

        // Then

        assertThat(result)
                .isEqualTo("ccc");
    }

    @Test
    public void switcheroo_whenLargeString_returnExpected() {

        // Given
        final String input = "bbbacccabbb";

        // When
        final String result = Switch.switcheroo(input);

        // Then

        assertThat(result)
                .isEqualTo("aaabcccbaaa");
    }
}
