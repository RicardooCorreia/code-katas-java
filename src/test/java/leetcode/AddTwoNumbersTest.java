package leetcode;

import leetcode.util.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static leetcode.util.ListNode.listToListNode;
import static org.assertj.core.api.Assertions.assertThat;

class AddTwoNumbersTest {

    private final AddTwoNumbers.Solution subject = new AddTwoNumbers.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.of(List.of(2, 4, 3), List.of(5, 6, 4), List.of(7, 0, 8)),
                Arguments.of(List.of(0), List.of(0), List.of(0)),
                Arguments.of(List.of(9, 9, 9, 9, 9, 9, 9), List.of(9, 9, 9, 9), List.of(8, 9, 9, 9, 0, 0, 0, 1))
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void addTwoNumbers_examples(List<Integer> input1, List<Integer> input2, List<Integer> expected) {

        // Given
        ListNode i1 = listToListNode(input1);
        ListNode i2 = listToListNode(input2);

        // When
        ListNode result = subject.addTwoNumbers(i1, i2);

        // Then
        assertThat(result)
                .isEqualTo(listToListNode(expected));
    }
}