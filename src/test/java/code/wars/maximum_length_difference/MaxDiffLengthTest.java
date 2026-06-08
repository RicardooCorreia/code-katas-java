package code.wars.maximum_length_difference;

import org.junit.jupiter.api.Test;

import static code.wars.maximum_length_difference.MaxDiffLength.mxdiflg;
import static org.assertj.core.api.Assertions.assertThat;

class MaxDiffLengthTest {

    @Test
    void should_returnMaximumLengthDifference_when_givenTwoStringArrays() {
        // given
        String[] s1 = new String[]{"hoqq", "bbllkw", "oox", "ejjuyyy", "plmiis", "xxxzgpsssa", "xxwwkktt", "znnnnfqknaz", "qqquuhii", "dvvvwz"};
        String[] s2 = new String[]{"cccooommaaqqoxii", "gggqaffhhh", "tttoowwwmmww"};

        // when
        int result = mxdiflg(s1, s2);

        // then
        assertThat(result).isEqualTo(13);
    }
}
