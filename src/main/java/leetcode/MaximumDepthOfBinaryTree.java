package leetcode;

import leetcode.util.TreeNode;

/*
Given the root of a binary tree, return its maximum depth.
A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Example 1:
    Input: root = [3,9,20,null,null,15,7]
    Output: 3
Example 2:
    Input: root = [1,null,2]
    Output: 2

Constraints:
    The number of nodes in the tree is in the range [0, 104].
    -100 <= Node.val <= 100
 */
public class MaximumDepthOfBinaryTree {

    static class Solution {
        public int maxDepth(TreeNode root) {

            if (root == null) {
                return 0;
            }

            return Math.max(maxDepth(root.left, 1), maxDepth(root.right, 1));
        }

        public int maxDepth(TreeNode node, int currentDepth) {
            if (node == null) {
                return currentDepth;
            }

            return Math.max(maxDepth(node.left, currentDepth + 1), maxDepth(node.right, currentDepth + 1));
        }
    }
}
