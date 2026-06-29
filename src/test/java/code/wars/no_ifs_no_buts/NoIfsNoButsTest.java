package code.wars.no_ifs_no_buts;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class NoIfsNoButsTest {

    @ParameterizedTest
    @CsvSource({"45, 51, 45 is smaller than 51", "1, 2, 1 is smaller than 2", "-3, 2, -3 is smaller than 2"})
    void should_returnSmallerThan_when_firstIsSmaller(int a, int b, String expected) {
        // given
        // inputs from CsvSource

        // when
        var result = NoIfsNoButs.noIfsNoButs(a, b);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"1, 1, 1 is equal to 1", "100, 100, 100 is equal to 100"})
    void should_returnEqualTo_when_bothAreEqual(int a, int b, String expected) {
        // given
        // inputs from CsvSource

        // when
        var result = NoIfsNoButs.noIfsNoButs(a, b);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"100, 80, 100 is greater than 80", "20, 19, 20 is greater than 19"})
    void should_returnGreaterThan_when_firstIsGreater(int a, int b, String expected) {
        // given
        // inputs from CsvSource

        // when
        var result = NoIfsNoButs.noIfsNoButs(a, b);

        // then
        assertThat(result).isEqualTo(expected);
    }
}
