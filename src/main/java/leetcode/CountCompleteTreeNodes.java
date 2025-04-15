package leetcode;

import leetcode.util.TreeNode;

/*
Given the root of a complete binary tree, return the number of the nodes in the tree.
According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree,
 and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
Design an algorithm that runs in less than O(n) time complexity.

Example 1:
    Input: root = [1,2,3,4,5,6]
    Output: 6
Example 2:
    Input: root = []
    Output: 0
Example 3:
    Input: root = [1]
    Output: 1

Constraints:
    The number of nodes in the tree is in the range [0, 5 * 104].
    0 <= Node.val <= 5 * 104
    The tree is guaranteed to be complete.
 */
public class CountCompleteTreeNodes {

    static class Solution {
        public int countNodes(TreeNode root) {
            if (root == null) return 0;
            int rightDepth = getDepth(root.left, true) + 1;
            int leftDepth = getDepth(root.right, false) + 1;
            if (rightDepth == leftDepth) return (int) ((Math.pow(2, rightDepth)) - 1);
            return 1 + countNodes(root.left) + countNodes(root.right);
        }

        private int getDepth(TreeNode root, boolean left) {
            int depth = 0;
            while (root != null) {
                root = left ? root.left : root.right;
                depth++;
            }
            return depth;
        }
    }
}
