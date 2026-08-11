package code.wars.from_a_to_z;

import static code.wars.from_a_to_z.Solution.gimmeTheLetters;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SolutionTest {

    @ParameterizedTest(name = "s = \"{0}\"")
    @CsvSource(textBlock = """
        a-z, abcdefghijklmnopqrstuvwxyz
        h-o, hijklmno
        Q-Z, QRSTUVWXYZ
        J-J, J
        a-b, ab
        a-a, a
        g-i, ghi
        H-I, HI
        y-z, yz
        e-k, efghijk
        a-q, abcdefghijklmnopq
        F-O, FGHIJKLMNO
    """)
    void should_returnLetterRange_when_givenRangeString(String input, String expected) {
        // given
        // input from CsvSource

        // when
        String result = gimmeTheLetters(input);

        // then
        assertThat(result).isEqualTo(expected);
    }
}