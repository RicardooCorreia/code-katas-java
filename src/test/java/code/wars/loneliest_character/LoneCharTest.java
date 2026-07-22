package code.wars.loneliest_character;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LoneCharTest {

    @ParameterizedTest
    @MethodSource("loneliestProvider")
    void should_returnLoneliestCharacters_when_givenString(String input, char[] expected) {
        // given
        // input from MethodSource

        // when
        char[] result = LoneChar.loneliest(input);

        // then
        assertThat(result).containsExactly(expected);
    }

    static Stream<Arguments> loneliestProvider() {
        return Stream.of(
            Arguments.of("a", new char[] { 'a' }),
            Arguments.of("abc d   ef  g   h i j      ", new char[] { 'g' }),
            Arguments.of("a   b   c ", new char[] { 'b' }),
            Arguments.of("  abc  d  z    f gk s ", new char[] { 'z' }),
            Arguments.of("a  b  c  de  ", new char[] { 'b', 'c' }),
            Arguments.of("abc", new char[] { 'a', 'b', 'c' })
        );
    }
}