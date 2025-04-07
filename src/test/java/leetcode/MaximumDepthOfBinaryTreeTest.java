package leetcode;

import leetcode.util.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaximumDepthOfBinaryTreeTest {

    private final MaximumDepthOfBinaryTree.Solution subject = new MaximumDepthOfBinaryTree.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.of(
                        new TreeNode(3,
                                new TreeNode(9),
                                new TreeNode(20,
                                        new TreeNode(15),
                                        new TreeNode(7))),
                        3
                ),
                Arguments.of(
                        new TreeNode(1,
                                null,
                                new TreeNode(2)),
                        2
                ),
                Arguments.of(
                        new TreeNode(0),
                        1
                )
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void maxDepth_examples(
            // Given
            TreeNode input,
            int expected
    ) {
        // When
        int result = subject.maxDepth(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}