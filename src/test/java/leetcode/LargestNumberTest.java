package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LargestNumberTest {

    private final LargestNumber.Solution subject = new LargestNumber.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments(new int[]{10, 2}, "210"),
                Arguments.arguments(new int[]{3, 30, 34, 5, 9}, "9534330")
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void largestNumber(
            // Given
            int[] nums,
            String expected) {

        // When
        String result = subject.largestNumber(nums);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}