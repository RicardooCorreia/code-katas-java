package code.wars.mean_vs_median;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void should_returnSame_when_meanEqualsMedian() {
        // given
        int[] arr = new int[]{1, 1, 1};

        // when
        String result = Solution.meanVsMedian(arr);

        // then
        assertThat(result).isEqualTo("same");
    }

    @Test
    void should_returnMean_when_meanGreaterThanMedian() {
        // given
        int[] arr = new int[]{1, 2, 37};

        // when
        String result = Solution.meanVsMedian(arr);

        // then
        assertThat(result).isEqualTo("mean");
    }

    @Test
    void should_returnMedian_when_medianGreaterThanMean() {
        // given
        int[] arr = new int[]{7, 14, -70};

        // when
        String result = Solution.meanVsMedian(arr);

        // then
        assertThat(result).isEqualTo("median");
    }
}
