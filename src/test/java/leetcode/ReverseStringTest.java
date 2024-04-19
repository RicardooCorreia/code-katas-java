package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ReverseStringTest {

    private final ReverseString.Solution subject = new ReverseString.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments(new char[]{'h', 'e', 'l', 'l', 'o'}, new char[]{'o', 'l', 'l', 'e', 'h'}),
                Arguments.arguments(new char[]{'H', 'a', 'n', 'n', 'a', 'h'}, new char[]{'h', 'a', 'n', 'n', 'a', 'H'})
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void reverseString(
            // Given
            char[] input,
            char[] expected) {

        // When
        subject.reverseString(input);

        // Then
        assertThat(input)
                .isEqualTo(expected);
    }
}