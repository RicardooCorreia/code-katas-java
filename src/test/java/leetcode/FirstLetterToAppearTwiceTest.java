package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FirstLetterToAppearTwiceTest {

    private final FirstLetterToAppearTwice.Solution subject = new FirstLetterToAppearTwice.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.of("abccbaacz", 'c'),
                Arguments.of("abcdd", 'd')
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void repeatedCharacter(
            // Given
            String s, char expected) {

        // When
        char result = subject.repeatedCharacter(s);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}