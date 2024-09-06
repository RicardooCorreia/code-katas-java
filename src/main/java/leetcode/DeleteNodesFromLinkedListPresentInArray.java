package leetcode;

import leetcode.util.ListNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class DeleteNodesFromLinkedListPresentInArray {

    static class Solution {
        public ListNode modifiedList(int[] nums, ListNode head) {

            ListNode dummy = new ListNode(-1, head);
            ListNode current = dummy;

            Set<Integer> numbersToRemove = Arrays.stream(nums)
                    .boxed()
                    .collect(Collectors.toSet());

            while (current.next != null) {
                int val = current.next.val;
                if (numbersToRemove.contains(val)) {
                    current.next = current.next.next;
                } else {
                    current = current.next;
                }
            }
            return dummy.next;
        }
    }
}
