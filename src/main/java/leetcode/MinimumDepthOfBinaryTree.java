package leetcode;

import leetcode.util.TreeNode;

/*
Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
Note: A leaf is a node with no children.

Example 1:
    Input: root = [3,9,20,null,null,15,7]
    Output: 2
Example 2:
    Input: root = [2,null,3,null,4,null,5,null,6]
    Output: 5

Constraints:
    The number of nodes in the tree is in the range [0, 105].
    -1000 <= Node.val <= 1000
 */
public class MinimumDepthOfBinaryTree {

    static class Solution {
        public int minDepth(TreeNode root) {

            if (root == null) {
                return 0;
            } else if (root.left == null && root.right == null) {
                return 1;
            }

            int leftDepth = minDepth(root.left, 1);
            int rightDepth = minDepth(root.right, 1);
            return Math.min(leftDepth, rightDepth);
        }

        private int minDepth(TreeNode node, int currentDepth) {

            if (node == null) {
                return Integer.MAX_VALUE;
            } else if (isLeaf(node)) {
                return currentDepth + 1;
            } else {
                int leftDepth = minDepth(node.left, currentDepth + 1);
                int rightDepth = minDepth(node.right, currentDepth + 1);
                return Math.min(leftDepth, rightDepth);
            }

        }

        private static boolean isLeaf(TreeNode node) {
            return node.left == null && node.right == null;
        }
    }
}
