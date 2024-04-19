package code.wars.your_order_please;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class OrderTest {

    public static Stream<Arguments> words() {

        return Stream.of(
                arguments("is2 Thi1s T4est 3a", "Thi1s is2 3a T4est"),
                arguments("4of Fo1r pe6ople g3ood th5e the2", "Fo1r the2 g3ood 4of th5e pe6ople")
        );
    }

    @Test
    void order_whenEmptyString_returnEmptyString() {

        // Given
        final String input = "";

        // When
        final String result = Order.order(input);

        // Then
        assertThat(result)
                .isEqualTo("");
    }

    @ParameterizedTest
    @MethodSource("words")
    void order_whenValidString_returnSortedString(
            // Given
            String input,
            String expected) {

        // When
        final String result = Order.order(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}