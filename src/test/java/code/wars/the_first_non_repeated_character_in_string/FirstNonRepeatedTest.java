package code.wars.the_first_non_repeated_character_in_string;

import static code.wars.the_first_non_repeated_character_in_string.FirstNonRepeated.firstNonRepeated;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class FirstNonRepeatedTest {

    @ParameterizedTest(name = "input = \"{0}\"")
    @CsvSource(textBlock = """
            test, e
            teeter, r
            1122321235121222, 5
            aabbcc, 
            """)
    void should_returnFirstNonRepeatedCharacter_when_givenString(
        // given
        String input, Character expected) {

        // when
        Character output = firstNonRepeated(input);

        // then
        assertThat(output).isEqualTo(expected);
    }
}
