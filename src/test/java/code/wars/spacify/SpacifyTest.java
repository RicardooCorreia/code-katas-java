package code.wars.spacify;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SpacifyTest {

    @Test
    public void spacify() {

        // Given
        final String input = "hello world";

        // When
        final String result = Spacify.spacify(input);

        // Then
        assertThat(result)
                .isEqualTo("h e l l o   w o r l d");
    }
}
