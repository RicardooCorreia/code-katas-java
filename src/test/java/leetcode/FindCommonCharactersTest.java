package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FindCommonCharactersTest {

    private final FindCommonCharacters.Solution subject = new FindCommonCharacters.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments(new String[]{"bella", "label", "roller"}, List.of("e", "l", "l")),
                Arguments.arguments(new String[]{"cool", "lock", "cook"}, List.of("c", "o"))
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void commonChars(
            // Given
            String[] input,
            List<String> expected) {

        // When
        List<String> result = subject.commonChars(input);

        // Then
        assertThat(result)
                .containsExactlyInAnyOrderElementsOf(expected);
    }
}