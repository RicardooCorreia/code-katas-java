package code.wars.sum_string_as_numbers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KataTest {

    @Test
    void sumStrings() {

        // Given
        final String a = "123";
        final String b = "456";

        // When
        final String result = Kata.sumStrings(a, b);

        // Then
        assertThat(result)
                .isEqualTo("579");
    }
}
