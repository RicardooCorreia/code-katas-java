package leetcode;

import leetcode.util.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ConvertSortedArrayToBinarySearchTreeTest {

    private final ConvertSortedArrayToBinarySearchTree.Solution subject = new ConvertSortedArrayToBinarySearchTree.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments(
                        new int[]{-10, -3, 0, 5, 9},
                        new TreeNode(0,
                                new TreeNode(-10,
                                        null,
                                        new TreeNode(-3)
                                ),
                                new TreeNode(5,
                                        null,
                                        new TreeNode(9)
                                )
                        )
                ),
                Arguments.arguments(
                        new int[]{1, 3},
                        new TreeNode(3,
                                new TreeNode(1),
                                null
                        )
                )
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void sortedArrayToBST(
            // Given
            int[] nums,
            TreeNode expected
    ) {

        // When
        TreeNode result = subject.sortedArrayToBST(nums);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}
