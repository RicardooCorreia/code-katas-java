package code.wars.playing_with_digits;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DigPowTest {

    @Test
    public void digPow_whenHasResult_returnResult() {

        // Given
        final int n = 89;
        final int p = 1;

        // When
        final long result = DigPow.digPow(n, p);

        // Then
        assertThat(result)
                .isEqualTo(1);
    }

    @Test
    public void digPow_whenDoesNotHaveResult_returnMinusOne() {

        // Given
        final int n = 92;
        final int p = 1;

        // When
        final long result = DigPow.digPow(n, p);

        // Then
        assertThat(result)
                .isEqualTo(-1);
    }

    @Test
    public void digPow_whenIsLargeNumberAndHasResult_returnResult() {

        // Given
        final int n = 46288;
        final int p = 3;

        // When
        final long result = DigPow.digPow(n, p);

        // Then
        assertThat(result)
                .isEqualTo(51);
    }
}
