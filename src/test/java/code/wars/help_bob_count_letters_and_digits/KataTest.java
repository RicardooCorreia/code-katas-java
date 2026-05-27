package code.wars.help_bob_count_letters_and_digits;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static code.wars.help_bob_count_letters_and_digits.Kata.countLettersAndDigits;
import static org.assertj.core.api.Assertions.assertThat;

public class KataTest {

    @ParameterizedTest(name = "countLettersAndDigits(\"{0}\") should return {1}")
    @CsvSource({
        "hel2!lo, 6",
        "n!!_ice!!123, 7",
        "1, 1",
        "?, 0",
        "'', 0",
        "12345f%%%t5t&/6, 10",
        "aBcDeFg090, 10",
        "u_n_d_e_r__S_C_O_R_E, 10"
    })
    public void testSampleCases(
        // given
        String input, int expected) {

        // when
        var result = countLettersAndDigits(input);

        // then
        assertThat(result)
            .isEqualTo(expected);
    }
}