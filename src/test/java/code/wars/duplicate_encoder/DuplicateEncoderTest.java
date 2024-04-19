package code.wars.duplicate_encoder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class DuplicateEncoderTest {

    public static Stream<Arguments> scenarios() {

        return Stream.of(
                arguments("Prespecialized", ")()())()(()()("),
                arguments("   ()(   ", "))))())))")
        );
    }

    @ParameterizedTest
    @MethodSource("scenarios")
    void encode_replacesDuplicatesAndNonDuplicates(
            // Given
            String input,
            String expected) {

        // When
        final String result = DuplicateEncoder.encode(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }

    @Test
    void encode_whenTheresNoDuplicates_returnReplacedChars() {

        // Given
        final String input = "abcefg";

        // When
        final String result = DuplicateEncoder.encode(input);

        // Then
        assertThat(result)
                .isEqualTo("((((((");
    }

    @Test
    void encode_whenIsAllDuplicates_returnReplacedChars() {

        // Given
        final String input = "aaaaaa";

        // When
        final String result = DuplicateEncoder.encode(input);

        // Then
        assertThat(result)
                .isEqualTo("))))))");
    }
}