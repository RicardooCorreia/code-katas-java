package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EncodeAndDecodeTinyURLTest {

    private final EncodeAndDecodeTinyURL.Codec subject = new EncodeAndDecodeTinyURL.Codec();

    @Test
    void encodeAndDecode() {

        // Given
        String url = "https://leetcode.com/problems/design-tinyurl";

        // When
        String encoded = subject.encode(url);
        String decoded = subject.decode(encoded);

        // Then
        assertThat(decoded)
                .isGreaterThan(encoded)
                .isEqualTo(url);
    }
}