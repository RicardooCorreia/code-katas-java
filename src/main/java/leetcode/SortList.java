package leetcode;

import leetcode.util.ListNode;

import java.util.LinkedList;
import java.util.List;

/*
Given the head of a linked list, return the list after sorting it in ascending order.

Example 1:
    Input: head = [4,2,1,3]
    Output: [1,2,3,4]
Example 2:
    Input: head = [-1,5,3,4,0]
    Output: [-1,0,3,4,5]
Example 3:
    Input: head = []
    Output: []

Constraints:
    The number of nodes in the list is in the range [0, 5 * 104].
    -105 <= Node.val <= 105

Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
 */
public class SortList {

    static class Solution {
        public ListNode sortList(ListNode head) {

            if (head == null || head.next == null) {
                return head;
            }

            ListNode current = new ListNode(0, head);
            List<Integer> numbers = new LinkedList<>();
            while (current.next != null) {
                numbers.add(current.next.val);
                current = current.next;
            }

            List<Integer> sortedList = numbers.stream()
                    .sorted()
                    .toList();

            ListNode newHead = new ListNode(sortedList.get(0));
            ListNode newCurrent = newHead;
            for (int i = 1; i < sortedList.size(); i++) {
                ListNode node = new ListNode(sortedList.get(i));
                newCurrent.next = node;
                newCurrent = node;
            }

            return newHead;
        }
    }
}
