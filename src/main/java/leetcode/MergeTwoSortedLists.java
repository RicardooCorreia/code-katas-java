package leetcode;

import java.util.Objects;

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 * Example 1:
 *      Input: list1 = [1,2,4], list2 = [1,3,4]
 *      Output: [1,1,2,3,4,4]
 * Example 2:
 *      Input: list1 = [], list2 = []
 *      Output: []
 * Example 3:
 *      Input: list1 = [], list2 = [0]
 *      Output: [0]
 * Constraints:
 *      The number of nodes in both lists is in the range [0, 50].
 *      -100 <= Node.val <= 100
 *      Both list1 and list2 are sorted in non-decreasing order.
 */
public class MergeTwoSortedLists {

    static class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

            ListNode dummy = new ListNode();
            ListNode previous = dummy;
            ListNode element1 = list1;
            ListNode element2 = list2;

            while(element1 != null || element2 != null) {

                ListNode current = new ListNode();
                previous.next = current;

                int value1 = element1 == null ? Integer.MAX_VALUE : element1.val;
                int value2 = element2 == null ? Integer.MAX_VALUE : element2.val;

                if (value1 < value2) {
                    current.val = value1;
                    element1 = element1.next;
                } else {
                    current.val = value2;
                    element2 = element2.next;
                }

                previous = current;

            }

            return dummy.next;
        }
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("ListNode{");
            sb.append("val=").append(val);
            sb.append(", next=").append(next);
            sb.append('}');
            return sb.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ListNode listNode = (ListNode) o;
            return val == listNode.val && Objects.equals(next, listNode.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, next);
        }
    }
}
