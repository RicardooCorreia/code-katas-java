package leetcode;

import leetcode.util.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchInBinarySearchTreeTest {

    private final SearchInBinarySearchTree.Solution subject = new SearchInBinarySearchTree.Solution();

    @Test
    void searchBST_whenHasValue_returnSubtree() {

        // Given
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        int target = 2;

        // When
        TreeNode result = subject.searchBST(root, target);

        // Then
        assertNotNull(result);
        assertEquals(target, result.val);
    }

    @Test
    void searchBST_whenHasNoValue_returnEmpty() {

        // Given
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        int target = 5;

        // When
        TreeNode result = subject.searchBST(root, target);

        // Then
        assertNull(result);
    }
}