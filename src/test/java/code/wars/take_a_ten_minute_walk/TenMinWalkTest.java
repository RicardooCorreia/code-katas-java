package code.wars.take_a_ten_minute_walk;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TenMinWalkTest {

    @Test
    void isValid_whenHas10BlocksAndReturnToTheSamePlace_returnFalse() {

        // Given
        final char[] input = {'n', 's', 'n', 's', 'n', 's', 'n', 's', 'n', 's'};

        // When
        final boolean result = TenMinWalk.isValid(input);

        // Then
        assertThat(result)
                .isTrue();
    }

    @Test
    void isValid_whenHasLessThan10Blocks_returnFalse() {

        // Given
        final char[] input = {'w'};

        // When
        final boolean result = TenMinWalk.isValid(input);

        // Then
        assertThat(result)
                .isFalse();
    }

    @Test
    void isValid_whenHasMoreThan10Blocks_returnFalse() {

        // Given
        final char[] input = {'w', 'e', 'w', 'e', 'w', 'e', 'w', 'e', 'w', 'e', 'w', 'e'};

        // When
        final boolean result = TenMinWalk.isValid(input);

        // Then
        assertThat(result)
                .isFalse();
    }

    @Test
    void isValid_whenHas10BlocksButDoesNotLandInTheSamePlace_returnFalse() {

        // Given
        final char[] input = {'n', 'n', 'n', 's', 'n', 's', 'n', 's', 'n', 's'};

        // When
        final boolean result = TenMinWalk.isValid(input);

        // Then
        assertThat(result)
                .isFalse();
    }
}