package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class RichestCustomerWealthTest {

    private final RichestCustomerWealth.Solution subject = new RichestCustomerWealth.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments(new int[][]{{1, 2, 3}, {3, 2, 1}}, 6),
                Arguments.arguments(new int[][]{{1, 5}, {7, 3}, {3, 5}}, 10),
                Arguments.arguments(new int[][]{{2, 8, 7}, {7, 1, 3}, {1, 9, 5}}, 17)
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void maximumWealth(
            // Given
            int[][] input,
            int expected) {

        // When
        int result = subject.maximumWealth(input);

        // Then
        assert expected == result;
    }
}