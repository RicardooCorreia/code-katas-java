package code.wars.valid_phone_number;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KataTest {

    @Test
    public void validPhoneNumber_whenValid_returnTrue() {

        // Given
        String input = "(1111)555 2345";

        // When
        boolean result = Kata.validPhoneNumber(input);

        // Then
        assertThat(result)
                .isFalse();
    }

    @Test
    public void validPhoneNumber_whenNotValid_returnFalse() {

        // Given
        String input = "(1111)555 2345";

        // When
        boolean result = Kata.validPhoneNumber(input);

        // Then
        assertThat(result)
                .isFalse();
    }

    @Test
    public void validPhoneNumber_whenMissingDash_returnFalse() {

        // Given
        String input = "(098) 123 4567";

        // When
        boolean result = Kata.validPhoneNumber(input);

        // Then
        assertThat(result)
                .isFalse();
    }
}
