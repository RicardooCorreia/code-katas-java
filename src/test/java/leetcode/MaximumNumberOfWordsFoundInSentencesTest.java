package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaximumNumberOfWordsFoundInSentencesTest {

    private final MaximumNumberOfWordsFoundInSentences.Solution subject = new MaximumNumberOfWordsFoundInSentences.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments(new String[]{"alice and bob love leetcode", "i think so too", "this is great thanks very much"}, 6),
                Arguments.arguments(new String[]{"please wait", "continue to fight", "continue to win"}, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void mostWordsFound(
            // Given
            String[] sentences,
            int expected) {

        // When
        int result = subject.mostWordsFound(sentences);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}