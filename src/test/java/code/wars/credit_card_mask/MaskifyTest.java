package code.wars.credit_card_mask;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MaskifyTest {

    @Test
    void maskify_whenReceivesCreditCardNumber_returnMaskedValue() {

        // Given
        final String input = "4556364607935616";

        // When
        final String result = Maskify.maskify(input);

        // Then
        assertThat(result)
                .isEqualTo("############5616");
    }

    @Test
    void maskify_whenItsSmallerThanFourChars_doNothing() {

        // Given
        final String input = "1";

        // When
        final String result = Maskify.maskify(input);

        // Then
        assertThat(result)
                .isEqualTo("1");
    }

    @Test
    void maskify_whenItsEmpty_returnEmpty() {

        // Given
        final String input = "";

        // When
        final String result = Maskify.maskify(input);

        // Then
        assertThat(result)
                .isEqualTo("");
    }
}