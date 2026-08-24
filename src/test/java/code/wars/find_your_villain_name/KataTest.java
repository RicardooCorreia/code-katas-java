package code.wars.find_your_villain_name;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class KataTest {

    @ParameterizedTest
    @CsvSource({
        "2000, 1, 1, The Evil Pickle",
        "2000, 2, 2, The Vile Hood Ornament",
        "2000, 12, 2, The Awkward Hood Ornament"
    })
    void should_returnVillainName_when_givenDate(int year, int month, int day, String expected) {
        // given
        LocalDate date = LocalDate.of(year, month, day);

        // when
        String result = Kata.getVillianName(date);

        // then
        assertThat(result).isEqualTo(expected);
    }
}