package code.wars.can_you_get_the_loop;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LoopInspectorTest {

    @ParameterizedTest
    @CsvSource({
            "1, 3",
            "21, 29",
            "3904, 1087"
    })
    void should_returnLoopSize_when_listContainsLoop(int tailLength, int loopSize) {
        // given
        Node list = createChain(tailLength, loopSize);

        // when
        int result = new LoopInspector().loopSize(list);

        // then
        assertThat(result).isEqualTo(loopSize);
    }

    private static Node createChain(int tailLength, int loopSize) {
        Node loopStart = new Node(null);
        Node current = loopStart;
        for (int i = 1; i < loopSize; i++) {
            Node next = new Node(null);
            current.setNext(next);
            current = next;
        }
        current.setNext(loopStart);

        Node chainStart = loopStart;
        for (int i = 0; i < tailLength; i++) {
            chainStart = new Node(chainStart);
        }
        return chainStart;
    }
}