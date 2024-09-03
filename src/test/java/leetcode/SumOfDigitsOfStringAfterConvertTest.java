package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SumOfDigitsOfStringAfterConvertTest {

    private final SumOfDigitsOfStringAfterConvert.Solution subject = new SumOfDigitsOfStringAfterConvert.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments("iiii", 1, 36),
                Arguments.arguments("leetcode", 2, 6),
                Arguments.arguments("zbax", 2, 8)
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void getLucky(
            // Given
            String input,
            int k,
            int expected) {

        // When
        int result = subject.getLucky(input, k);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}