package leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringMatchingInAnArrayTest {

    private final StringMatchingInAnArray.Solution subject = new StringMatchingInAnArray.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.of(new String[]{"mass", "as", "hero", "superhero"}, new String[]{"as", "hero"}),
                Arguments.of(new String[]{"leetcode", "et", "code"}, new String[]{"et", "code"}),
                Arguments.of(new String[]{"blue", "green", "bu"}, new String[]{})
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void stringMatching(
            // Given
            String[] words,
            String[] expected) {

        // When
        List<String> result = subject.stringMatching(words);

        // Then
        assertThat(result)
                .containsExactlyInAnyOrder(expected);
    }
}