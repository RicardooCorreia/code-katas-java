package code.wars.suitcase_packing;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MrSquareTest {

    @Test
    void should_returnTrue_when_suitcaseFits() {
        // given
        int a = 1, b = 2, c = 3, d = 2;

        // when
        boolean result = MrSquare.fit_in(a, b, c, d);

        // then
        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @CsvSource({
        "1, 2, 2, 1",
        "3, 2, 3, 2",
        "1, 2, 1, 2",
        "6, 5, 8, 7"
    })
    void should_returnFalse_when_suitcaseDoesNotFit(int a, int b, int c, int d) {
        // given
        // input from CsvSource

        // when
        boolean result = MrSquare.fit_in(a, b, c, d);

        // then
        assertThat(result).isFalse();
    }
}