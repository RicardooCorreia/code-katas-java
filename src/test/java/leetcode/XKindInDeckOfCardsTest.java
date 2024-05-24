package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class XKindInDeckOfCardsTest {

    private final XKindInDeckOfCards.Solution subject = new XKindInDeckOfCards.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments(new int[]{1, 2, 3, 4, 4, 3, 2, 1}, true),
                Arguments.arguments(new int[]{1, 1, 1, 2, 2, 2, 3, 3}, false)
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void hasGroupsSizeX(
            // Given
            int[] input,
            boolean expected) {

        // When
        boolean result = subject.hasGroupsSizeX(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}