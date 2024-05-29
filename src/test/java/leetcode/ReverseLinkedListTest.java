package leetcode;

import leetcode.util.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ReverseLinkedListTest {

    private final ReverseLinkedList.Solution subject = new ReverseLinkedList.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments(ListNode.of(1, 2, 3, 4, 5), ListNode.of(5, 4, 3, 2, 1)),
                Arguments.arguments(ListNode.of(1, 2), ListNode.of(2, 1))
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void reverseList(
            // Given
            ListNode input,
            ListNode expected) {

        // When
        ListNode result = subject.reverseList(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}