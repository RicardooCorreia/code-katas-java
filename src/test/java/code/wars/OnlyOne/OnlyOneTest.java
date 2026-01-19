package code.wars.OnlyOne;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OnlyOneTest {

    @Test
    void onlyOne_whenEmptyInput_returnFalse() {

        // Given
        // No input

        // When
        boolean result = OnlyOne.onlyOne();

        // Then
        assertThat(result).isFalse();
    }

    @Test
    void onlyOne_whenContainsExactlyOneTrue_returnTrue() {

        // Given
        Boolean[] input = {true, false, false};

        // When
        boolean result = OnlyOne.onlyOne(input);

        // Then
        assertThat(result).isTrue();
    }

    @Test
    void onlyOne_whenContainsMultipleTrues_returnFalse() {

        // Given
        Boolean[] input = {true, false, false, true};

        // When
        boolean result = OnlyOne.onlyOne(input);

        // Then
        assertThat(result).isFalse();
    }

    @Test
    void onlyOne_whenContainsOnlyFalse_returnFalse() {

        // Given
        Boolean[] input = {false, false, false, false};

        // When
        boolean result = OnlyOne.onlyOne(input);

        // Then
        assertThat(result).isFalse();
    }
}
