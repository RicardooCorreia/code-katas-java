package leetcode;

import leetcode.util.ListNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RemoveLinkedListElementsTest {

    private final RemoveLinkedListElements.Solution subject = new RemoveLinkedListElements.Solution();

    @Test
    void removeElements() {

        // Given
        ListNode input = ListNode.of(1, 2, 6, 3, 4, 5, 6);
        int valToRemove = 6;

        // When
        ListNode result = subject.removeElements(input, valToRemove);

        // Then
        assertThat(result)
                .isEqualTo(ListNode.of(1, 2, 3, 4, 5));
    }

    @Test
    void removeElements_whenRemovingOnlyElement() {

        // Given
        ListNode input = ListNode.of(1);
        int valToRemove = 1;

        // When
        ListNode result = subject.removeElements(input, valToRemove);

        // Then
        assertThat(result)
                .isNull();
    }

    @Test
    void removeElements_whenAllElements() {

        // Given
        ListNode input = ListNode.of(7, 7, 7, 7);
        int valToRemove = 7;

        // When
        ListNode result = subject.removeElements(input, valToRemove);

        // Then
        assertThat(result)
                .isNull();
    }

    @Test
    void removeElements_whenRemovingEmpty() {

        // Given
        ListNode input = null;
        int valToRemove = 7;

        // When
        ListNode result = subject.removeElements(input, valToRemove);

        // Then
        assertThat(result)
                .isNull();
    }
}