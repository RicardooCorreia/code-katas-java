package leetcode;

import leetcode.util.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SumOfLeftLeavesTest {

    private final SumOfLeftLeaves.Solution subject = new SumOfLeftLeaves.Solution();

    @Test
    void sumOfLeftLeaves() {

        // Given
        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)));

        // When
        int result = subject.sumOfLeftLeaves(root);

        // Then
        assertThat(result)
                .isEqualTo(24);
    }
}
