package leetcode;

import leetcode.util.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveDuplicatesFromSortedListTest {

    private final RemoveDuplicatesFromSortedList.Solution subject = new RemoveDuplicatesFromSortedList.Solution();

    public static Stream<Arguments> examples() {
        return Stream.of(
                Arguments.of(ListNode.of(1, 1, 2), ListNode.of(1, 2)),
                Arguments.of(ListNode.of(1, 1, 2, 3, 3), ListNode.of(1, 2, 3))
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void deleteDuplicates(
            // Given
            ListNode input,
            ListNode expected) {

        // When
        ListNode result = subject.deleteDuplicates(input);

        // Then
        assertEquals(expected, result);
    }
}