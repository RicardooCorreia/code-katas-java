package code.wars.create_phone_number;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KataTest {

    @Test
    void createPhoneNumber_createdPhoneNumber() {

        // Given
        final int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

        // When
        final String result = Kata.createPhoneNumber(input);

        // Then
        assertThat(result)
                .isEqualTo("(123) 456-7890");
    }
}