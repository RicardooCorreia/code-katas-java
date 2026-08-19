package code.wars.password_maker;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class KataTest {

    @ParameterizedTest
    @CsvSource({
        "Give me liberty or give me death, Gml0gmd",
        "Keep Calm and Carry On, KCaC0",
        "'', ''"
    })
    void should_returnPassword_when_phraseProvided(String phrase, String expected) {
        // given
        // input from CsvSource

        // when
        String result = Kata.makePassword(phrase);

        // then
        assertThat(result).isEqualTo(expected);
    }
}