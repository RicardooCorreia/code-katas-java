package leetcode;

import leetcode.util.ListNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RemoveNodesFromLinkedListTest {

    private final RemoveNodesFromLinkedList.Solution subject = new RemoveNodesFromLinkedList.Solution();

    @Test
    void removeNodes_whenHasHigherNumberToTheRight_removeNumbers() {

        // Given
        ListNode input = ListNode.of(5, 2, 13, 3, 8);

        // When
        ListNode result = subject.removeNodes(input);

        // Then
        assertThat(result)
                .isEqualTo(ListNode.of(13, 8));
    }

    @Test
    void removeNodes_whenHasNoHigherNumberToTheRight_dontRemoveAnything() {

        // Given
        ListNode input = ListNode.of(1, 1, 1, 1, 1);

        // When
        ListNode result = subject.removeNodes(input);

        // Then
        assertThat(result)
                .isEqualTo(input);
    }
}