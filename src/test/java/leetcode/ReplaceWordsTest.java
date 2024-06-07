package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ReplaceWordsTest {

    private final ReplaceWords.Solution subject = new ReplaceWords.Solution();

    public static Stream<Arguments> examples() {
        return Stream.of(
                Arguments.arguments(List.of("cat", "bat", "rat"), "the cattle was rattled by the battery", "the cat was rat by the bat"),
                Arguments.arguments(List.of("catt", "cat", "bat", "rat"), "the cattle was rattled by the battery", "the cat was rat by the bat"),
                Arguments.arguments(List.of("a", "b", "c"), "aadsfasf absbs bbab cadsfafs", "a a b c")
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void replaceWords(
            // Given
            List<String> dictionary,
            String sentence,
            String expected) {

        // When
        String result = subject.replaceWords(dictionary, sentence);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}