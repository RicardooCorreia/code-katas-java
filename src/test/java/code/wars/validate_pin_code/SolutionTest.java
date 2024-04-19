package code.wars.validate_pin_code;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SolutionTest {

    public static Stream<Arguments> validPins() {

        return Stream.of(
                arguments("1234"),
                arguments("0000"),
                arguments("1111"),
                arguments("123456"),
                arguments("098765"),
                arguments("000000"),
                arguments("090909")
        );
    }

    public static Stream<Arguments> invalidChars() {

        return Stream.of(
                arguments("a234"),
                arguments(".234")
        );
    }

    public static Stream<Arguments> invalidLengths() {

        return Stream.of(
                arguments("1"),
                arguments("12"),
                arguments("123"),
                arguments("12345"),
                arguments("1234567"),
                arguments("-1234"),
                arguments("1.234"),
                arguments("00000000"),
                arguments("1234   " +
                        "")
        );
    }

    @ParameterizedTest
    @MethodSource("validPins")
    public void validatePin_whenValid_returnTrue(
            // Given
            String pin) {

        // When
        final boolean result = Solution.validatePin(pin);

        // Then
        assertThat(result)
                .isTrue();
    }

    @ParameterizedTest
    @MethodSource("invalidChars")
    public void validatePin_whenInvalidChars_returnFalse(
            // Given
            String pin) {

        // When
        final boolean result = Solution.validatePin(pin);

        // Then
        assertThat(result)
                .isFalse();
    }

    @ParameterizedTest
    @MethodSource("invalidLengths")
    public void validatePin_whenInvalidLengths_returnFalse(
            // Given
            String pin) {

        // When
        final boolean result = Solution.validatePin(pin);

        // Then
        assertThat(result)
                .isFalse();
    }
}
