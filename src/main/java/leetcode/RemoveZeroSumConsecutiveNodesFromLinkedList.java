package leetcode;

import leetcode.util.ListNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class RemoveZeroSumConsecutiveNodesFromLinkedList {

    static class Solution {
        public ListNode removeZeroSumSublists(ListNode head) {

            Integer[] valueArray = getArray(head);
            for (int i = 0; i < valueArray.length; i++) {
                checkSubsets(i, valueArray);
            }
            return arrayToListNode(valueArray);
        }

        private static Integer[] getArray(ListNode head) {
            LinkedList<Integer> values = new LinkedList<>();
            ListNode current = head;
            while (current != null) {
                values.add(current.val);
                current = current.next;
            }
            Integer[] valueArray = values.toArray(value -> new Integer[values.size()]);
            return valueArray;
        }

        private static void checkSubsets(int from, Integer[] values) {
            int currentCount = 0;
            for (int i = from; i < values.length; i++) {
                Integer value = values[i];
                if (value != null) {
                    currentCount += value;
                    if (currentCount == 0) {
                        removeElements(from, i, values);
                        return;
                    }
                }
            }
        }

        private static void removeElements(int from, int to, Integer[] array) {
            for (int i = from; i <= to; i++) {
                array[i] = null;
            }
        }

        private static ListNode arrayToListNode(Integer[] valueArray) {
            ListNode newHead = new ListNode();
            ListNode newCurrent = newHead;
            for (Integer value : valueArray) {
                if (value != null) {
                    newCurrent.next = new ListNode(value);
                    newCurrent = newCurrent.next;
                }
            }
            return newHead.next;
        }
    }

    static class Solution2 {
        public ListNode removeZeroSumSublists(ListNode head) {

            int runningSum = 0;
            Map<Integer, ListNode> sumNodeMap = new HashMap<>();
            ListNode dummyHead = new ListNode();
            dummyHead.next = head;
            sumNodeMap.put(0, dummyHead);
            for (ListNode current = head; current != null; current = current.next) {
                runningSum += current.val;

                if (sumNodeMap.containsKey(runningSum)) {
                    ListNode previous = sumNodeMap.get(runningSum);
                    int sumToBeRemoved = runningSum;
                    while (previous != current) {
                        previous = previous.next;
                        sumToBeRemoved += (previous != null) ? previous.val : 0;
                        if (previous != current)
                            sumNodeMap.remove(sumToBeRemoved);

                    }
                    sumNodeMap.get(runningSum).next = current.next;
                } else if (runningSum != 0)
                    sumNodeMap.put(runningSum, current);
            }
            return dummyHead.next;
        }
    }
}
