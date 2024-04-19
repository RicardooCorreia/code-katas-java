package code.wars.array_diff;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class KataTest {


    public static Stream<Arguments> arrays() {

        return Stream.of(
                arguments(new int[]{1, 2}, new int[]{1}, new int[]{2}),
                arguments(new int[]{1, 2, 2}, new int[]{1}, new int[]{2, 2}),
                arguments(new int[]{1, 2, 2}, new int[]{2}, new int[]{1}),
                arguments(new int[]{1, 2, 2}, new int[]{}, new int[]{1, 2, 2}),
                arguments(new int[]{}, new int[]{1, 2}, new int[]{})
        );
    }

    @ParameterizedTest
    @MethodSource("arrays")
    public void sampleTests(
            // Given
            int[] array1,
            int[] array2,
            int[] expected) {

        // When
        final int[] result = Kata.arrayDiff(array1, array2);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}