package code.wars.sort_by_last_char;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static code.wars.sort_by_last_char.Kata.last;
import static org.assertj.core.api.Assertions.assertThat;

class KataTest {

    @ParameterizedTest
    @MethodSource("testCases")
    void should_sortByLastChar_when_validInput(String input, String[] expected) {
        // given
        // input from MethodSource

        // when
        String[] result = last(input);

        // then
        assertThat(result).containsExactly(expected);
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
            Arguments.of("man i need a taxi up to ubud", new String[]{"a", "need", "ubud", "i", "taxi", "man", "to", "up"}),
            Arguments.of("what time are we climbing up the volcano", new String[]{"time", "are", "we", "the", "climbing", "volcano", "up", "what"}),
            Arguments.of("take me to semynak", new String[]{"take", "me", "semynak", "to"}),
            Arguments.of("massage yes massage yes massage", new String[]{"massage", "massage", "massage", "yes", "yes"}),
            Arguments.of("take bintang and a dance please", new String[]{"a", "and", "take", "dance", "please", "bintang"})
        );
    }
}