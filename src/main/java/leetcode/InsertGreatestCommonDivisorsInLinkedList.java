package leetcode;

import leetcode.util.ListNode;

public class InsertGreatestCommonDivisorsInLinkedList {

    static class Solution {
        public ListNode insertGreatestCommonDivisors(ListNode head) {

            ListNode previous = head;
            ListNode current = head.next;

            while (current != null) {
                int previousVal = previous.val;
                int currentVal = current.val;
                int greatestCommonDivisor = getGreatestCommonDivisor(previousVal, currentVal);

                previous.next = new ListNode(greatestCommonDivisor, current);

                previous = current;
                current = current.next;
            }

            return head;
        }

        private int getGreatestCommonDivisor(int previousVal, int currentVal) {
            return currentVal == 0 ? previousVal : getGreatestCommonDivisor(currentVal, previousVal % currentVal);
        }
    }
}
