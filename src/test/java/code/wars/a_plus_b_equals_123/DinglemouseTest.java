package code.wars.a_plus_b_equals_123;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DinglemouseTest {

    @Test
    public void int123_whenAisLesserThan123_thenReturnCorrectB() {

        // Given
        final int input = 0;

        // When
        final long result = Dinglemouse.int123(input);

        // Then
        assertThat(result)
                .isGreaterThanOrEqualTo(0);
        assertThat((int) (input + result))
                .isEqualTo(123);
    }

    @Test
    public void int123_whenAisAlready123_thenReturnZero() {

        // Given
        final int input = 123;

        // When
        final long result = Dinglemouse.int123(input);

        // Then
        assertThat(result)
                .isGreaterThanOrEqualTo(0);
        assertThat((int) (input + result))
                .isEqualTo(123);
    }

    @Test
    public void int123_whenAisBiggerThan123_thenReturnPositiveBThatAddsTo123() {

        // Given
        final int input = 500;

        // When
        final long result = Dinglemouse.int123(input);

        // Then
        assertThat(result)
                .isGreaterThanOrEqualTo(0);
        assertThat((int) (input + result))
                .isEqualTo(123);
    }

    @Test
    public void int123_whenAisMuchBiggerThan123_thenReturnPositiveBThatAddsTo123() {

        // Given
        final int input = 99999;

        // When
        final long result = Dinglemouse.int123(input);

        // Then
        assertThat(result)
                .isGreaterThanOrEqualTo(0);
        assertThat((int) (input + result))
                .isEqualTo(123);
    }
}
