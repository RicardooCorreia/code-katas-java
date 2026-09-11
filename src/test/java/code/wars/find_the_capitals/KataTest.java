package code.wars.find_the_capitals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class KataTest {

    @ParameterizedTest
    @MethodSource("capitalInputs")
    void should_returnCapitalIndices_when_stringProvided(String input, int[] expected) {
        // given - input from MethodSource

        // when
        int[] actual = Kata.capitals(input);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> capitalInputs() {
        return Stream.of(
                Arguments.of("CodEWaRs", new int[]{0, 3, 4, 6}),
                Arguments.of("aAbB", new int[]{1, 3}),
                Arguments.of("AAA", new int[]{0, 1, 2}),
                Arguments.of("abcdefghijklmnopqrstuvwxyz", new int[]{}),
                Arguments.of("ZYXWVUTSRQPONMLKJIHGFEDCBA",
                        new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25}),
                Arguments.of("", new int[]{}));
    }
}