package code.wars.simple_fun_165_withdraw;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    public static Stream<Arguments> withdrawTestCases() {
        return Stream.of(
                Arguments.arguments(40, new int[]{0, 0, 2}),
                Arguments.arguments(250, new int[]{2, 1, 0}),
                Arguments.arguments(260, new int[]{2, 0, 3}),
                Arguments.arguments(230, new int[]{1, 1, 4}),
                Arguments.arguments(60, new int[]{0, 0, 3})
        );
    }

    @ParameterizedTest
    @MethodSource("withdrawTestCases")
    void withdraw_whenGivenAmount_returnCorrectBillCombination(
            // Given
            int amount,
            int[] expected
    ) {

        // When
        final int[] result = Solution.withdraw(amount);

        // Then
        assertThat(result)
                .containsExactly(expected);
    }
}
