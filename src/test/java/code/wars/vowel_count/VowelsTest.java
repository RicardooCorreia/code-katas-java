package code.wars.vowel_count;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class VowelsTest {

    @Test
    public void getCount() {

        // Given
        final String input = "abracadabra";

        // When
        final int result = Vowels.getCount(input);

        // Then
        assertThat(result)
                .isEqualTo(5);
    }
}
