package code.wars.phone_words;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PhoneWordsTest {

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                arguments("443355555566604466690277733099966688", "hello how are you"),
                arguments("55282", "kata"),
                arguments("44460208337777833777", "im a tester"),
                arguments("22266631339277717777", "codewars"),
                arguments("66885551555", "null"),
                arguments("833998", "text"),
                arguments("000", "   "),
                arguments("528882", "java"),
                arguments("55886444833", "kumite"),
                arguments("271755533", "apple"),
                arguments("1111", "")
        );
    }

    @Test
    void phoneWords_whenEmpty_returnEmpty() {

        // Given
        String input = "";

        // When
        String result = PhoneWords.phoneWords(input);

        // Then
        assertThat(result)
                .isEqualTo("");
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    void phoneWords_baseTests(
            // Given
            String input,
            String expected) {

        // When
        String result = PhoneWords.phoneWords(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}
