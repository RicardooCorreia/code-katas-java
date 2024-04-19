package code.wars.youre_a_square;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SquareTest {

    public static Stream<Arguments> squareNumbers() {

        return Stream.of(
                arguments(0, "0 is square: 0 * 0 = 0"),
                arguments(4, "4 is square: 2 * 2 = 4"),
                arguments(25, "25 square: 5 * 5 = 25"));
    }

    public static Stream<Arguments> notSquareNumbers() {

        return Stream.of(
                arguments(-1, "Negative numbers aren't square numbers"),
                arguments(3, "3 isn't a square number"),
                arguments(26, "26 isn't a square number"));
    }

    @ParameterizedTest
    @MethodSource("squareNumbers")
    void isSquare_whenIsSquare_returnTrue(
            // Given
            int number,
            String description) {

        // When
        final boolean result = Square.isSquare(number);

        // Then
        assertThat(result)
                .describedAs(description)
                .isTrue();
    }

    @ParameterizedTest
    @MethodSource("notSquareNumbers")
    void isSquare_whenIsNotSquare_returnFalse(
            // Given
            int number,
            String description) {

        // When
        final boolean result = Square.isSquare(number);

        // Then
        assertThat(result)
                .describedAs(description)
                .isFalse();
    }
}