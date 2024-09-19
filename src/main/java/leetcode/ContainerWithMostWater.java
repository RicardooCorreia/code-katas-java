package leetcode;

/*
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the
 ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, such that the container contains the most water.
Return the maximum amount of water a container can store.
Notice that you may not slant the container.

Example 1:
    Input: height = [1,8,6,2,5,4,8,3,7]
    Output: 49
    Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
Example 2:
    Input: height = [1,1]
    Output: 1

Constraints:
    n == height.length
    2 <= n <= 105
    0 <= height[i] <= 104
 */
public class ContainerWithMostWater {

    static class Solution {
        public int maxArea(int[] height) {

            if (height == null || height.length < 2)
                return 0;

            int pointer1 = 0, pointer2 = height.length - 1;
            int maxArea = Integer.MIN_VALUE;
            while (pointer1 != pointer2) {
                int pillar1 = height[pointer1];
                int pillar2 = height[pointer2];
                int currentArea = (pointer2 - pointer1) * Math.min(pillar1, pillar2);
                maxArea = Math.max(currentArea, maxArea);
                if (pillar1 > pillar2) {
                    pointer2--;
                } else {
                    pointer1++;
                }
            }
            return maxArea;
        }
    }
}
