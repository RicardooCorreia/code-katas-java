package code.wars.backspaces_in_string;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BackspacesInStringTest {

    @Test
    public void cleanString_whenHasElements_removeExpectedElements() {

        // Given
        final BackspacesInString bis = new BackspacesInString();


        // When
        String result = bis.cleanString("abc#d##c");

        // Then
        assertThat(result)
                .isEqualTo("ac");
    }

    @Test
    public void cleanString_whenHasMoreBackspacesThanElements_removeExpectedElements() {

        // Given
        final BackspacesInString bis = new BackspacesInString();


        // When
        String result = bis.cleanString("abc####d##c#");

        // Then
        assertThat(result)
                .isEqualTo("");
    }
}
