package code.wars.sum_of_numbers_from_zero_to_n;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SequenceSumTest {

    @Test
    void should_returnSumSequence_when_nIsSix() {
        // given
        int n = 6;

        // when
        String result = SequenceSum.showSequence(n);

        // then
        assertThat(result).isEqualTo("0+1+2+3+4+5+6 = 21");
    }
}