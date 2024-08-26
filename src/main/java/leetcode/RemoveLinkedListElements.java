package leetcode;

import leetcode.util.ListNode;

public class RemoveLinkedListElements {

    static class Solution {
        public ListNode removeElements(ListNode head, int val) {

            if (head == null) {
                return null;
            }

            ListNode current = head;
            ListNode dummy = new ListNode(-1, current);
            ListNode previous = dummy;
            while (current != null) {
                if (current.val == val) {
                    previous.next = current.next;
                } else {
                    previous = current;
                }
                current = current.next;
            }
            return dummy.next;
        }
    }
}
