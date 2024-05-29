package leetcode;

import leetcode.util.ListNode;

import java.util.Stack;

/*
Given the head of a singly linked list, reverse the list, and return the reversed list.

Example 1:
    Input: head = [1,2,3,4,5]
    Output: [5,4,3,2,1]
Example 2:
    Input: head = [1,2]
    Output: [2,1]
Example 3:
    Input: head = []
    Output: []

Constraints:
    The number of nodes in the list is the range [0, 5000].
    -5000 <= Node.val <= 5000

Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class ReverseLinkedList {

    static class Solution {
        public ListNode reverseList(ListNode head) {

            Stack<Integer> stack = new Stack<>();
            ListNode current = head;

            while (current != null) {
                stack.push(current.val);
                current = current.next;
            }

            ListNode dummy = new ListNode();
            current = dummy;
            while(!stack.isEmpty()) {
                ListNode listNode = new ListNode(stack.pop());
                current.next = listNode;
                current = listNode;
            }

            return dummy.next;
        }
    }
}
