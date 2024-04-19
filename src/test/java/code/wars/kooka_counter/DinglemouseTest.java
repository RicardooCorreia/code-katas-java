package code.wars.kooka_counter;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DinglemouseTest {

    @Test
    public void kookaCounter_whenEmpty_returnZero() {

        // Given
        String input = ("");

        // When
        int result = Dinglemouse.kookaCounter(input);

        // Then
        assertThat(result)
                .isEqualTo(0);
    }

    @Test
    public void kookaCounter_whenLongerLaugh_returnSingleOne() {

        // Given
        String input = "hahahahaha";

        // When
        int result = Dinglemouse.kookaCounter(input);

        // Then
        assertThat(result)
                .isEqualTo(1);
    }

    @Test
    public void kookaCounter_whenInterpolatedLaugh_returnCorrectAmount() {

        // Given
        String input = "HahaHahaHahahaha";

        // When
        int result = Dinglemouse.kookaCounter(input);

        // Then
        assertThat(result)
                .isEqualTo(6);
    }
}
