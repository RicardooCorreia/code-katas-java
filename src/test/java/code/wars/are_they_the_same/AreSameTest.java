package code.wars.are_they_the_same;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AreSameTest {

    @Test
    void comp_whenFirstIsNull_returnFalse() {

        // Given
        final int[] a = null;
        final int[] b = {1, 2};

        // When
        final boolean result = AreSame.comp(a, b);

        // Then
        assertThat(result)
                .isFalse();
    }

    @Test
    void comp_whenSecondIsNull_returnFalse() {

        // Given
        final int[] a = {1, 2};
        final int[] b = null;

        // When
        final boolean result = AreSame.comp(a, b);

        // Then
        assertThat(result)
                .isFalse();
    }

    @Test
    void comp_whenFirstIsEmpty_returnFalse() {

        // Given
        final int[] a = {};
        final int[] b = {1, 2};

        // When
        final boolean result = AreSame.comp(a, b);

        // Then
        assertThat(result)
                .isFalse();
    }

    @Test
    void comp_whenSecondIsEmpty_returnFalse() {

        // Given
        final int[] a = {1, 2};
        final int[] b = {};

        // When
        final boolean result = AreSame.comp(a, b);

        // Then
        assertThat(result)
                .isFalse();
    }

    @Test
    void comp_whenAreTheSame_returnTrue() {

        // Given
        final int[] a = {121, 144, 19, 161, 19, 144, 19, 11};
        final int[] b = {121, 14641, 20736, 361, 25921, 361, 20736, 361};
        // B is equal to [11*11, 121*121, 144*144, 19*19, 161*161, 19*19, 144*144, 19*19]

        // When
        final boolean result = AreSame.comp(a, b);

        // Then
        assertThat(result)
                .isTrue();
    }

    @Test
    void comp_whenAreNotTheSameByANumber_returnFalse() {

        // Given
        final int[] a = {121, 144, 19, 161, 19, 144, 19, 11};
        final int[] b = {132, 14641, 20736, 361, 25921, 361, 20736, 361};
        // B is equal to [132, 121*121, 144*144, 19*19, 161*161, 19*19, 144*144, 19*19]

        // When
        final boolean result = AreSame.comp(a, b);

        // Then
        assertThat(result)
                .isFalse();
    }
}