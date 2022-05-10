package code.wars.largest_5_digits;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LargestFiveDigitNumberTest {

    public static Stream<Arguments> baseTests() {

        return Stream.of(
                arguments("283910", 83910),
                arguments("1234567890", 67890),
                arguments("731674765", 74765)
        );
    }

    @ParameterizedTest
    @MethodSource("baseTests")
    public void solve_returnLargestConsecutiveFiveDigits(
            // Given
            String input,
            int expected) {

        // When
        final int result = LargestFiveDigitNumber.solve(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}
