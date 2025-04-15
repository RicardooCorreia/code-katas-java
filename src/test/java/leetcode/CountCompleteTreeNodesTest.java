package leetcode;

import leetcode.util.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CountCompleteTreeNodesTest {

    private final CountCompleteTreeNodes.Solution subject = new CountCompleteTreeNodes.Solution();

    @Test
    void countNodes() {

        // Given
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3,
                        new TreeNode(6),
                        null));

        // When
        int result = subject.countNodes(root);

        // Then
        assertThat(result)
                .isEqualTo(6);
    }

    @Test
    void countNodes_deeperLevel() {

        // Given
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4,
                                new TreeNode(8),
                                new TreeNode(9)),
                        new TreeNode(5,
                                new TreeNode(10),
                                new TreeNode(11))),
                new TreeNode(2,
                        new TreeNode(4,
                                new TreeNode(8),
                                new TreeNode(9)),
                        new TreeNode(5,
                                new TreeNode(10),
                                new TreeNode(11)))
        );

        // When
        int result = subject.countNodes(root);

        // Then
        assertThat(result)
                .isEqualTo(15);
    }

    @Test
    void countNodes_whenEmpty_returnZero() {

        // Given
        TreeNode root = null;

        // When
        int result = subject.countNodes(root);

        // Then
        assertThat(result)
                .isEqualTo(0);
    }

    @Test
    void countNodes_whenSingleNumber_returnOne() {

        // Given
        TreeNode root = new TreeNode(1);

        // When
        int result = subject.countNodes(root);

        // Then
        assertThat(result)
                .isEqualTo(1);
    }

    @Test
    void countNodes_shortTree() {

        // Given
        TreeNode root = new TreeNode(1,
                new TreeNode(2),
                null);

        // When
        int result = subject.countNodes(root);

        // Then
        assertThat(result)
                .isEqualTo(2);
    }
}
