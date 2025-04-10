package leetcode;

import leetcode.util.TreeNode;

/*
Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

Example 1:
    Input: nums = [-10,-3,0,5,9]
    Output: [0,-3,9,-10,null,5]
    Explanation: [0,-10,5,null,-3,null,9] is also accepted:
Example 2:
    Input: nums = [1,3]
    Output: [3,1]
    Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.

Constraints:
    1 <= nums.length <= 104
    -104 <= nums[i] <= 104
    nums is sorted in a strictly increasing order.
 */
public class ConvertSortedArrayToBinarySearchTree {

    static class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {

            if (nums.length == 0) {
                return null;
            }

            TreeNode root = new TreeNode(nums[nums.length / 2]);
            root.left = sortedArrayToBST(nums, 0, nums.length / 2 - 1);;
            root.right = sortedArrayToBST(nums, nums.length / 2 + 1, nums.length - 1);;
            return root;
        }

        private TreeNode sortedArrayToBST(int[] nums, int from, int to) {

            if (from > to) {
                return null;
            }

            int mid = (from + to) / 2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = sortedArrayToBST(nums, from, mid - 1);
            node.right = sortedArrayToBST(nums, mid + 1, to);
            return node;
        }
    }
}
