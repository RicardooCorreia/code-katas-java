package code.wars.simple_pig_latin;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PigLatinTest {

    public static Stream<Arguments> phrases() {

        return Stream.of(
                arguments("Pig latin is cool", "igPay atinlay siay oolcay"),
                arguments("This is my string", "hisTay siay ymay tringsay")
        );
    }

    @ParameterizedTest
    @MethodSource("phrases")
    void pigIt_moveFirstLetterAndAddSuffix(
            // Given
            String input,
            String expected) {

        // When
        final String result = PigLatin.pigIt(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }

    @Test
    void pigIt_whenSpecialCharacters_doesNotLatinIt() {

        // Given
        final String input = "![] . /&%";


        // When
        final String result = PigLatin.pigIt(input);

        // Then
        assertThat(result)
                .isEqualTo(input);
    }
}