package leetcode;

/*
Given an array of integers nums, sort the array in ascending order and return it.
You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space complexity possible.

Example 1:
    Input: nums = [5,2,3,1]
    Output: [1,2,3,5]
    Explanation: After sorting the array, the positions of some numbers are not changed (for example, 2 and 3), while the positions of other numbers are changed (for example, 1 and 5).
Example 2:
    Input: nums = [5,1,1,2,0,0]
    Output: [0,0,1,1,2,5]
    Explanation: Note that the values of nums are not necessairly unique.

Constraints:
    1 <= nums.length <= 5 * 104
    -5 * 104 <= nums[i] <= 5 * 104
 */
public class SortAnArray {

    static class Solution {
        public int[] sortArray(int[] nums) {

            mergeSort(nums, 0, nums.length - 1);
            return nums;
        }

        private void mergeSort(int[] nums, int left, int right) {
            if (left < right) {
                int mid = (left + right) / 2;
                mergeSort(nums, left, mid);
                mergeSort(nums, mid + 1, right);
                merge(nums, left, mid, right);
            }
        }

        private void merge(int[] nums, int left, int mid, int right) {
            int n1 = mid - left + 1;
            int n2 = right - mid;

            int[] leftArray = new int[n1];
            int[] rightArray = new int[n2];

            for (int i = 0; i < n1; i++) {
                leftArray[i] = nums[left + i];
            }
            for (int i = 0; i < n2; i++) {
                rightArray[i] = nums[mid + 1 + i];
            }

            int i = 0, j = 0, k = left;
            while (i < n1 && j < n2) {
                if (leftArray[i] <= rightArray[j]) {
                    nums[k++] = leftArray[i++];
                } else {
                    nums[k++] = rightArray[j++];
                }
            }

            while (i < n1) {
                nums[k++] = leftArray[i++];
            }
            while (j < n2) {
                nums[k++] = rightArray[j++];
            }
        }
    }
}
