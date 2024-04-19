package leetcode;

import leetcode.util.ListNode;

import java.util.Objects;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Example 1:
 *      Input: l1 = [2,4,3], l2 = [5,6,4]
 *      Output: [7,0,8]
 *      Explanation: 342 + 465 = 807.
 * Example 2:
 *      Input: l1 = [0], l2 = [0]
 *      Output: [0]
 * Example 3:
 *      Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 *      Output: [8,9,9,9,0,0,0,1]
 * Constraints:
 *      The number of nodes in each linked list is in the range [1, 100].
 *      0 <= Node.val <= 9
 *      It is guaranteed that the list represents a number that does not have leading zeros.
 */
public class AddTwoNumbers {

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            ListNode firstNumber = l1;
            ListNode secondNumber = l2;
            int carry = 0;

            ListNode dummy = new ListNode();
            ListNode current = dummy;

            while (firstNumber != null || secondNumber != null || carry > 0) {

                int firstValue = getVal(firstNumber);
                int secondValue = getVal(secondNumber);

                int addition = firstValue + secondValue + carry;
                int number = addition % 10;
                carry = addition / 10;

                current.next = new ListNode(number);
                current = current.next;

                firstNumber = getNext(firstNumber);
                secondNumber = getNext(secondNumber);
            }

            return dummy.next;
        }

        private static ListNode getNext(ListNode node) {
            return node == null ? null : node.next;
        }

        private static int getVal(ListNode node) {
            return node != null ? node.val : 0;
        }
    }
}
