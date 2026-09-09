package code.wars.keypad_horror;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BudTest {

    @ParameterizedTest
    @CsvSource({
            "0789456123, 0123456789",
            "000, 000",
            "94561, 34567",
            "'', ''"
    })
    void should_convertToPhoneKeypadLayout_when_inputIsComputerKeypadLayout(String input, String expected) {
        // given - input from CsvSource

        // when
        String result = Bud.computerToPhone(input);

        // then
        assertThat(result).isEqualTo(expected);
    }
}