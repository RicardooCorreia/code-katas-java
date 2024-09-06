package leetcode;

import leetcode.util.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class DeleteNodesFromLinkedListPresentInArrayTest {

    private final DeleteNodesFromLinkedListPresentInArray.Solution subject = new DeleteNodesFromLinkedListPresentInArray.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments(new int[]{1, 2, 3}, ListNode.of(1, 2, 3, 4, 5), ListNode.of(4, 5)),
                Arguments.arguments(new int[]{1}, ListNode.of(1, 2, 1, 2, 1, 2), ListNode.of(2, 2, 2)),
                Arguments.arguments(new int[]{5}, ListNode.of(1, 2, 3, 4), ListNode.of(1, 2, 3, 4))
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void modifiedList(
            // Given
            int[] input,
            ListNode head,
            ListNode expected) {

        // When
        ListNode result = subject.modifiedList(input, head);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}