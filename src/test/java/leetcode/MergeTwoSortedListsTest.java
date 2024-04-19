package leetcode;

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
        MergeTwoSortedLists.ListNode result = subject.mergeTwoLists(listToListNode(list1), listToListNode(list2));

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
        MergeTwoSortedLists.ListNode result = subject.mergeTwoLists(listToListNode(list1), listToListNode(list2));

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
        MergeTwoSortedLists.ListNode result = subject.mergeTwoLists(listToListNode(list1), listToListNode(list2));

        // Then
        assertThat(result)
                .isEqualTo(new MergeTwoSortedLists.ListNode(1));
    }

    public MergeTwoSortedLists.ListNode listToListNode(List<Integer> integerList) {

        if (integerList == null || integerList.size() == 0) {
            return null;
        }

        if (integerList.size() == 1) {
            return new MergeTwoSortedLists.ListNode(integerList.get(0));
        }

        MergeTwoSortedLists.ListNode firstNode = new MergeTwoSortedLists.ListNode();
        firstNode.val = integerList.get(0);

        MergeTwoSortedLists.ListNode current = firstNode;
        for (int i = 1; i < integerList.size(); i++) {
            MergeTwoSortedLists.ListNode node = new MergeTwoSortedLists.ListNode();
            node.val = integerList.get(i);
            current.next = node;
            current = node;
        }

        return firstNode;
    }
}