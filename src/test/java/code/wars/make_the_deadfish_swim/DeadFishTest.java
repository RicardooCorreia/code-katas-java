package code.wars.make_the_deadfish_swim;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class DeadFishTest {

    public static Stream<Arguments> testCases() {

        return Stream.of(
                arguments("iiisdoso", new int[]{8, 64}),
                arguments("iiisdosodddddiso", new int[]{8, 64, 3600})
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void parse_testCases(
            // Given
            String input,
            int[] expected) {

        // When
        final int[] result = DeadFish.parse(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}