package code.wars.count_characters_in_your_string;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class KataTest {

    @ParameterizedTest
    @MethodSource("inputsAndExpectedCounts")
    void should_returnCharacterCounts_when_inputIsProvided(
        // given
        String input, Map<Character, Integer> expected) {

        // when
        Map<Character, Integer> result = Kata.count(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> inputsAndExpectedCounts() {
        return Stream.of(
                Arguments.of("", Map.of()),
                Arguments.of("a", Map.of('a', 1)),
                Arguments.of("aabbbac", Map.of('a', 3, 'b', 3, 'c', 1)),
                Arguments.of("abc", Map.of('a', 1, 'b', 1, 'c', 1)),
                Arguments.of("aaaaa", Map.of('a', 5)),
                Arguments.of("aabb", Map.of('a', 2, 'b', 2)));
    }
}
