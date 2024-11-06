package leetcode;

import leetcode.util.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SortListTest {

    private final SortList.Solution subject = new SortList.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments(ListNode.of(4, 2, 1, 3), ListNode.of(1, 2, 3, 4)),
                Arguments.arguments(ListNode.of(-1, 5, 3, 4, 0), ListNode.of(-1, 0, 3, 4, 5))
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void sortList(
            // Given
            ListNode head,
            ListNode expected) {

        // When
        ListNode result = subject.sortList(head);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}