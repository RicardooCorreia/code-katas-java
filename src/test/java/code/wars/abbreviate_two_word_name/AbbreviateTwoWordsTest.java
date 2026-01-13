package code.wars.abbreviate_two_word_name;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class AbbreviateTwoWordsTest {

    public static Stream<Arguments> examples() {
        return Stream.of(
                Arguments.arguments("Sam Harris", "S.H"),
                Arguments.arguments("patrick feeney", "P.F"),
                Arguments.arguments("John Doe", "J.D"),
                Arguments.arguments("alice cooper", "A.C"),
                Arguments.arguments("P Favuzzi", "P.F")
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void abbrevName_examples(
            // Given
            String input,
            String expected
    ) {

        // When
        String result = AbbreviateTwoWords.abbrevName(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}
