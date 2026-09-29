package other;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class KthLargestElementTest {

    public static Stream<Arguments> examples() {

        return Stream.of(
                arguments(new int[]{3, 2, 1, 5, 6, 4}, 2, 5),
                arguments(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4, 4),
                arguments(new int[]{1}, 1, 1),
                arguments(new int[]{3, 3, 3, 3}, 2, 3),
                arguments(new int[]{5, 4, 3, 2, 1}, 5, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void name(
            // given
            int[] array,
            int k,
            int expected
    ) {

        // when
        int result = KthLargestElement.findKthLargest(array, k);

        // then
        assertThat(result)
                .isEqualTo(expected);
    }
}
