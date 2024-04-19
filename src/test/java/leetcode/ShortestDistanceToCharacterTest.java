package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ShortestDistanceToCharacterTest {

    private final ShortestDistanceToCharacter.Solution subject = new ShortestDistanceToCharacter.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.of("loveleetcode", 'e', new int[]{3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0}),
                Arguments.of("aaab", 'b', new int[]{3, 2, 1, 0})
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void shortestToChar(
            // Given
            String input,
            char theChar,
            int[] expected) {


        // When
        int[] result = subject.shortestToChar(input, theChar);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}