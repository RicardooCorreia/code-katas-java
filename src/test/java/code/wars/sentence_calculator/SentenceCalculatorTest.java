package code.wars.sentence_calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SentenceCalculatorTest {

    @ParameterizedTest
    @CsvSource({
        "I Love You, 170",
        "ILoveYou, 170",
        "ARE YOU HUNGRY?, 356",
        "oops i did it again!, 152",
        "Give me 5!, 73",
        "Give me five!, 110"
    })
    void should_returnCorrectSum_when_convertingLettersToNumbers(String input, int expected) {
        // given
        // input from CsvSource

        // when
        int result = SentenceCalculator.lettersToNumbers(input);

        // then
        assertThat(result).isEqualTo(expected);
    }
}