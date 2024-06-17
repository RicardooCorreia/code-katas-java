package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class JewelsAndStonesTest {

    private final JewelsAndStones.Solution subject = new JewelsAndStones.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments("aA", "aAAbbbb", 3),
                Arguments.arguments("z", "ZZ", 0));
    }

    @ParameterizedTest
    @MethodSource("examples")
    void numJewelsInStones(
            // Given
            String jewels,
            String stones,
            int expected) {

        // When
        int result = subject.numJewelsInStones(jewels, stones);

        // Then
        assert expected == result;
    }
}