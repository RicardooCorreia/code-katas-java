package code.wars.reverse_letter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class KataTest {

    @ParameterizedTest
    @CsvSource({
        "krishan, nahsirk",
        "ultr53o?n, nortlu",
        "ab23c, cba",
        "krish21an, nahsirk"
    })
    void should_returnReversedLetters_when_stringContainsNonLetters(String input, String expected) {
        // given
        // input from @CsvSource

        // when
        String result = Kata.reverseLetter(input);

        // then
        assertThat(result).isEqualTo(expected);
    }
}