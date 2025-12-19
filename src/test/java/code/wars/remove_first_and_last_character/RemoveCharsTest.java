package code.wars.remove_first_and_last_character;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RemoveCharsTest {

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.of("eloquent", "loquen"),
                Arguments.of("country", "ountr"),
                Arguments.of("person", "erso"),
                Arguments.of("place", "lac"),
                Arguments.of("ok", "")
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void remove_examples(
            // Given
            String str,
            String expected) {

        // When
        String result = RemoveChars.remove(str);

        // Then
        assertThat(result).isEqualTo(expected);
    }
}
