package leetcode;

import leetcode.util.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class InsertGreatestCommonDivisorsInLinkedListTest {

    private final InsertGreatestCommonDivisorsInLinkedList.Solution subject = new InsertGreatestCommonDivisorsInLinkedList.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments(ListNode.of(18, 6, 10, 3), ListNode.of(18, 6, 6, 2, 10, 1, 3)),
                Arguments.arguments(ListNode.of(7), ListNode.of(7))
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void insertGreatestCommonDivisors(
            // Given
            ListNode input,
            ListNode expected) {

        // When
        ListNode result = subject.insertGreatestCommonDivisors(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}