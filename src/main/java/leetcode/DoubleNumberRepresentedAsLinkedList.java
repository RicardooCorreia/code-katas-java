package leetcode;

import leetcode.util.ListNode;

import java.util.Stack;

/*
You are given the head of a non-empty linked list representing a non-negative integer without leading zeroes.
Return the head of the linked list after doubling it.

Example 1:
    Input: head = [1,8,9]
    Output: [3,7,8]
    Explanation: The figure above corresponds to the given linked list which represents the number 189. Hence, the returned linked list represents the number 189 * 2 = 378.
Example 2:
    Input: head = [9,9,9]
    Output: [1,9,9,8]
    Explanation: The figure above corresponds to the given linked list which represents the number 999. Hence, the returned linked list reprersents the number 999 * 2 = 1998.

Constraints:
    The number of nodes in the list is in the range [1, 104]
    0 <= Node.val <= 9
    The input is generated such that the list represents a number that does not have leading zeros, except the number 0 itself.
 */
public class DoubleNumberRepresentedAsLinkedList {

    static class Solution {
        public ListNode doubleIt(ListNode head) {

            ListNode current = head;
            Stack<Integer> stack = new Stack<>();
            while (current != null) {
                stack.push(current.val);
                current = current.next;
            }

            int remaining = 0;
            ListNode previous = new ListNode();
            ListNode newCurrent = new ListNode();
            while (!stack.isEmpty()) {
                Integer number = stack.pop();
                int multiplied = number * 2 + remaining;
                int newNumber = multiplied % 10;
                remaining = multiplied / 10;

                // Fill out LinkedList in reverse
                previous = new ListNode();
                newCurrent.val = newNumber;
                previous.next = newCurrent;
                newCurrent = previous;
            }

            if (remaining > 0) {
                newCurrent.val = remaining;
                newCurrent = new ListNode(0, newCurrent);
            }

            return newCurrent.next;
        }
    }
}
