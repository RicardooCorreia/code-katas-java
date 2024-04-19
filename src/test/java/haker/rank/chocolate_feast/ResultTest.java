package haker.rank.chocolate_feast;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ResultTest {

    public static Stream<Arguments> chocolates() {

        return Stream.of(
                arguments(10, 2, 5, 6),
                arguments(12, 4, 4, 3),
                arguments(6, 2, 2, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("chocolates")
    void chocolateFeast_whenHasWrappersToTurnIn_returnChocolatesEaten(
            // Given
            int money,
            int barCost,
            int wrappersConversion,
            int expected) {

        // When
        final int result = Result.chocolateFeast(money, barCost, wrappersConversion);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}