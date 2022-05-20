package code.wars.decode_the_morse_code;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MorseCodeDecoderTest {

    @Test
    public void decode() {

        // Given
        final String input = ".... . -.--   .--- ..- -.. .";

        // When
        final String result = MorseCodeDecoder.decode(input);

        // Then
        assertThat(result)
                .isEqualTo("HEY JUDE");
    }
}
