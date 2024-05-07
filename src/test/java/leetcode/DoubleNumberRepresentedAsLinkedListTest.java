package leetcode;

import leetcode.util.ListNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DoubleNumberRepresentedAsLinkedListTest {

    private final DoubleNumberRepresentedAsLinkedList.Solution subject = new DoubleNumberRepresentedAsLinkedList.Solution();

    @Test
    void doubleIt_baseTest() {

        // Given
        ListNode input = ListNode.of(1, 8, 9);

        // When
        ListNode result = this.subject.doubleIt(input);

        // Then
        assertThat(result)
                .isEqualTo(ListNode.of(3, 7, 8));
    }

    @Test
    void doubleIt_whenDoubleHasMoreElements() {

        // Given
        ListNode input = ListNode.of(9, 9, 9);

        // When
        ListNode result = this.subject.doubleIt(input);

        // Then
        assertThat(result)
                .isEqualTo(ListNode.of(1, 9, 9, 8));
    }
}