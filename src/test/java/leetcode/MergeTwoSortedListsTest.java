package leetcode;

import leetcode.util.ListNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MergeTwoSortedListsTest {

    private static final MergeTwoSortedLists.Solution subject = new MergeTwoSortedLists.Solution();

    @Test
    void mergeTwoLists_basicExample() {

        // Given
        List<Integer> list1 = List.of(1, 2, 4);
        List<Integer> list2 = List.of(1, 3, 4);

        // When
        ListNode result = subject.mergeTwoLists(listToListNode(list1), listToListNode(list2));

        // Then
        List<Integer> expected = List.of(1, 1, 2, 3, 4, 4);
        assertThat(result)
                .isEqualTo(listToListNode(expected));
    }

    @Test
    void mergeTwoLists_emptyList() {

        // Given
        List<Integer> list1 = List.of();
        List<Integer> list2 = List.of();

        // When
        ListNode result = subject.mergeTwoLists(listToListNode(list1), listToListNode(list2));

        // Then
        assertThat(result)
                .isEqualTo(null);
    }

    @Test
    void mergeTwoLists_singleElement() {

        // Given
        List<Integer> list1 = List.of();
        List<Integer> list2 = List.of(1);

        // When
        ListNode result = subject.mergeTwoLists(listToListNode(list1), listToListNode(list2));

        // Then
        assertThat(result)
                .isEqualTo(new ListNode(1));
    }

    public ListNode listToListNode(List<Integer> integerList) {

        if (integerList == null || integerList.size() == 0) {
            return null;
        }

        if (integerList.size() == 1) {
            return new ListNode(integerList.get(0));
        }

        ListNode firstNode = new ListNode();
        firstNode.val = integerList.get(0);

        ListNode current = firstNode;
        for (int i = 1; i < integerList.size(); i++) {
            ListNode node = new ListNode();
            node.val = integerList.get(i);
            current.next = node;
            current = node;
        }

        return firstNode;
    }
}