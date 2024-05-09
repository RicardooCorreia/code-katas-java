package leetcode;

import leetcode.util.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RemoveZeroSumConsecutiveNodesFromLinkedListTest {

    private final RemoveZeroSumConsecutiveNodesFromLinkedList.Solution subject = new RemoveZeroSumConsecutiveNodesFromLinkedList.Solution();
    private final RemoveZeroSumConsecutiveNodesFromLinkedList.Solution2 subject2 = new RemoveZeroSumConsecutiveNodesFromLinkedList.Solution2();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.of(List.of(1, 2, -3, 3, 1), List.of(3, 1)),
                Arguments.of(List.of(1, 2, 3, -3, 4), List.of(1, 2, 4)),
                Arguments.of(List.of(1, 2, 3, -3, -2), List.of(1))
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void removeZeroSumSublists(
            // Given
            List<Integer> input,
            List<Integer> expected) {

        // When
        ListNode result = subject.removeZeroSumSublists(ListNode.listToListNode(input));
        ListNode result2 = subject2.removeZeroSumSublists(ListNode.listToListNode(input));

        // Then
        assertThat(result)
                .isEqualTo(ListNode.listToListNode(expected))
                .isEqualTo(result2);
    }
}
