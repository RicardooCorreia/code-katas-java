package code.wars.arrh_grabscrab;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class GrabTest {

    @ParameterizedTest
    @MethodSource("baseScenarios")
    void grabscrab_withVariousAnagrams_returnsMatchingWords(
            // Given
            String anagram,
            List<String> words,
            List<String> expected) {

        // When
        var actual = Grab.grabscrab(anagram, words);

        // Then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> baseScenarios() {
        return Stream.of(
                Arguments.of("trisf", List.of("first"), List.of("first")),
                Arguments.of("oob", List.of("bob", "baobab"), List.of()),
                Arguments.of("ainstuomn", List.of("mountains", "hills", "mesa"), List.of("mountains")),
                Arguments.of("oolp", List.of("donkey", "pool", "horse", "loop"), List.of("pool", "loop")),
                Arguments.of("ortsp", List.of("sport", "parrot", "ports", "matey"), List.of("sport", "ports")),
                Arguments.of("ourf", List.of("one", "two", "three"), List.of())
        );
    }
}
