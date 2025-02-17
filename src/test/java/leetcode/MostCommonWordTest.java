package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MostCommonWordTest {

    private final MostCommonWord.Solution subject = new MostCommonWord.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}, "ball"),
                Arguments.arguments("a.", new String[]{}, "a")
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void mostCommonWord(
            // Given
            String paragraph,
            String[] banned,
            String expected) {

        // When
        String result = subject.mostCommonWord(paragraph, banned);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}