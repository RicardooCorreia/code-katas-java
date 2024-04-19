package code.wars.dont_give_me_five;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KataTest {

    @Test
    public void dontGiveMeFive_dontReturnNumbersContainingFive() {

        // Given
        final int start = 4;
        final int end = 17;

        // When
        final int result = Kata.dontGiveMeFive(start, end);

        // Then
        assertThat(result)
                .isEqualTo(12);
    }
}
