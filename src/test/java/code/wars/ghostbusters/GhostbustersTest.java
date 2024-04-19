package code.wars.ghostbusters;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GhostbustersTest {

    @Test
    void building_whenHasSpaces_removeSpaces() {

        // Given
        final String input = "O  f fi ce";

        // When
        final String result = Ghostbusters.ghostBusters(input);

        // Then
        assertThat(result)
                .isEqualTo("Office");
    }

    @Test
    public void building_whenHasNoSpaces_returnPhrase() {

        // Given
        final String input = "BusStation";

        // When
        final String result = Ghostbusters.ghostBusters(input);

        // Then
        assertThat(result)
                .isEqualTo("You just wanted my autograph didn't you?");
    }
}
