package code.wars.how_many_pages_in_a_book;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class HowManyPagesInABookTest {

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                arguments(5, 5),
                arguments(25, 17),
                arguments(1095, 401),
                arguments(185, 97),
                arguments(660, 256)
        );
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    public void amountOfPages_baseTests(
            // Given
            int summary,
            int expected) {

        // When
        final int result = HowManyPagesInABook.amountOfPages(summary);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }

    @Test
    void amountOfPages_whenIsVeryBigInput_returnCorrectResult() {

        // Given
        int summary = 10000;

        // When
        final int result = HowManyPagesInABook.amountOfPages(summary);

        // Then
        assertThat(result)
                .isEqualTo(966783966);
    }
}
