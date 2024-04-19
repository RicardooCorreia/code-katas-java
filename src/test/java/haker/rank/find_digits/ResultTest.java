package haker.rank.find_digits;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @ParameterizedTest
    @ValueSource(ints = {111, 124})
    void findDigits_whenAllDivisors_returnNumberLength(/* Given */ int number) {

        // When
        final int result = Result.findDigits(number);

        // Then
        assertThat(result)
                .isEqualTo(3);
    }

    @Test
    void findDigits_whenNotAllDivisors_returnCorrectValue() {

        // Given
        final int number = 10;

        // When
        final int result = Result.findDigits(number);

        // Then
        assertThat(result)
                .isEqualTo(1);
    }
}