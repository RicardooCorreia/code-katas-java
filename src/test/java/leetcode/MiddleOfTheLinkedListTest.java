package leetcode;

import leetcode.util.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MiddleOfTheLinkedListTest {

    private final MiddleOfTheLinkedList.Solution subject = new MiddleOfTheLinkedList.Solution();

    public static Stream<Arguments> examples() {
        return Stream.of(
                Arguments.arguments(ListNode.of(1, 2, 3, 4, 5), ListNode.of(3, 4, 5)),
                Arguments.arguments(ListNode.of(1, 2, 3, 4, 5, 6), ListNode.of(4, 5, 6))
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void middleNode(
            // Given
            ListNode input,
            ListNode expected) {

        // When
        ListNode result = subject.middleNode(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}