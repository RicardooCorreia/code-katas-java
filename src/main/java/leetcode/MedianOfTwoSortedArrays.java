package leetcode;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 * Example 1:
 *      Input: nums1 = [1,3], nums2 = [2]
 *      Output: 2.00000
 *      Explanation: merged array = [1,2,3] and median is 2.
 * Example 2:
 *      Input: nums1 = [1,2], nums2 = [3,4]
 *      Output: 2.50000
 *      Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * Constraints:
 *      nums1.length == m
 *      nums2.length == n
 *      0 <= m <= 1000
 *      0 <= n <= 1000
 *      1 <= m + n <= 2000
 *      -106 <= nums1[i], nums2[i] <= 106
 */
public class MedianOfTwoSortedArrays {

    static class Solution {

        public double findMedianSortedArrays(int[] nums1, int[] nums2) {

            int nums1Index = 0, nums2Index = 0;
            int nums1Length = nums1.length;
            int nums2Length = nums2.length;

            int totalLength = nums1Length + nums2Length;
            int mergedLength = (totalLength / 2) + 1;

            int[] merged = new int[mergedLength];

            for (int mergeIndex = 0; mergeIndex < mergedLength; mergeIndex++) {

                Integer num1 = nums1Index >= nums1Length ? null : nums1[nums1Index];
                Integer num2 = nums2Index >= nums2Length ? null : nums2[nums2Index];

                if (num2 == null || (num1 != null && num1 <= num2)) {
                    merged[mergeIndex] = num1;
                    nums1Index++;
                } else {
                    merged[mergeIndex] = num2;
                    nums2Index++;
                }
            }

            return median(merged, totalLength);
        }

        private static double median(int[] merged, int totalLength) {

            int length = merged.length;
            if (totalLength % 2 == 0) {
                return (merged[length - 1] + merged[length - 2]) / 2.0;
            } else {
                return merged[length - 1];
            }
        }
    }
}
