package other;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MissingNumberTest {

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                Arguments.arguments(new int[]{2, 4, 7, 3, 8, 5, 1}, 6),
                Arguments.arguments(new int[]{2, 4, 6, 7, 3, 8, 5}, 1),
                Arguments.arguments(new int[]{2, 1, 4}, 3),
                Arguments.arguments(new int[]{2, 1, 3}, 4),
                Arguments.arguments(new int[]{1}, 2),
                Arguments.arguments(new int[]{}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    void findMissing(
            // Given
            int[] input,
            int expected) {

        MissingNumber subject = new MissingNumber();

        // When
        int result = subject.findMissing(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}
