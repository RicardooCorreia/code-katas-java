package code.wars.does_my_number_look_big_in_this;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberUtilsTest {

    @Test
    void isNarcissistic_returnTrue() {

        // Given
        int number = 1634;

        // When
        boolean narcissistic = NumberUtils.isNarcissistic(number);

        // Then
        assertThat(narcissistic)
                .isTrue();
    }

    @Test
    void isNarcissistic_returnFalse() {

        // Given
        int number = 112;

        // When
        boolean narcissistic = NumberUtils.isNarcissistic(number);

        // Then
        assertThat(narcissistic)
                .isFalse();
    }
}
