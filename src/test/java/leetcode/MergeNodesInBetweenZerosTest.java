package leetcode;

import leetcode.util.ListNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MergeNodesInBetweenZerosTest {

    private final MergeNodesInBetweenZeros.Solution subject = new MergeNodesInBetweenZeros.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments(ListNode.of(0,3,1,0,4,5,2,0), ListNode.of(4,11)),
                Arguments.arguments(ListNode.of(0,1,0,3,0,2,2,0), ListNode.of(1,3,4))
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void mergeNodes(
        // Given
          ListNode input,
          ListNode expected) {

        // When
        ListNode result = subject.mergeNodes(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}