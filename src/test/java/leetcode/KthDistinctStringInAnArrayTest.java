package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KthDistinctStringInAnArrayTest {

    private final KthDistinctStringInAnArray.Solution subject = new KthDistinctStringInAnArray.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments(new String[]{"d", "b", "c", "b", "c", "a"}, 2, "a"),
                Arguments.arguments(new String[]{"aaa", "aa", "a"}, 1, "aaa"),
                Arguments.arguments(new String[]{"a", "b", "a"}, 3, "")
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void kthDistinct(
            // Given
            String[] arr,
            int k,
            String expected) {

        // When
        String result = subject.kthDistinct(arr, k);

        // Then
        assertEquals(expected, result);
    }
}