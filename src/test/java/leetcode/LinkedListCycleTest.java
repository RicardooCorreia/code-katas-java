package leetcode;

import leetcode.util.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LinkedListCycleTest {

    private final LinkedListCycle.Solution subject = new LinkedListCycle.Solution();

    @Test
    void hasCycle_whenHasCycle_returnTrue() {

        // Given
        ListNode head = new ListNode(3);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(0);
        ListNode fourth = new ListNode(-4);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second;

        // When
        boolean result = subject.hasCycle(head);

        // Then
        assertTrue(result);
    }

    @Test
    void hasCycle_whenHasSimpleCycle_returnTrue() {

        // Given
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        head.next = second;
        second.next = head;

        // When
        boolean result = subject.hasCycle(head);

        // Then
        assertTrue(result);
    }

    @Test
    void hasCycle_whenHasSingleElement_returnFalse() {

        // Given
        ListNode head = new ListNode(1);

        // When
        boolean result = subject.hasCycle(head);

        // Then
        assertFalse(result);
    }

    @Test
    void hasCycle_whenDoesNotHaveCycle_returnFalse() {

        // Given
        ListNode head = ListNode.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17);

        // When
        boolean result = subject.hasCycle(head);

        // Then
        assertFalse(result);
    }
}