package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ZigzagConversionTest {

    private static final ZigzagConversion.Solution subject = new ZigzagConversion.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.of("PAYPALISHIRING", 3, "PAHNAPLSIIGYIR"),
                Arguments.of("PAYPALISHIRING", 4, "PINALSIGYAHRPI"),
                Arguments.of("A", 1, "A"),
                Arguments.of("ABCD", 2, "ACBD")

        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void convert_examples(
            // Given
            String input,
            int rows,
            String expected) {

        // When
        String result = subject.convert(input, rows);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}