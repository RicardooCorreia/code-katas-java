package code.wars.sentence_smash;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SmashWordsTest {

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.of(new String[]{"hello"}, "hello"),
                Arguments.of(new String[]{"hello", "world"}, "hello world"),
                Arguments.of(new String[]{"hello", "world", "this", "is", "great"}, "hello world this is great")
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void smash_examples(
            // Given
            String[] input,
            String expected) {

        // When
        String result = SmashWords.smash(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }

    @Test
    void smash_trimSpaces() {

        // Given
        String[] input = {"   Hello", "World!!   "};

        // When
        String result = SmashWords.smash(input);

        // Then
        assertThat(result)
                .isEqualTo("Hello World!!");
    }
}
