package other;

import java.util.PriorityQueue;

public class KthLargestElement {

    public static int findKthLargest(int[] nums, int k) {

        if (nums.length == 0 || k == 0) {
            return 0;
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int num : nums) {
            if (priorityQueue.size() < k) {
                priorityQueue.offer(num);
            } else if (priorityQueue.peek() < num) {
                priorityQueue.poll();
                priorityQueue.offer(num);
            }
        }

        return priorityQueue.poll();
    }
}
