package code.wars.reverse_linked_list;

import code.wars.reverse_linked_list.Kata.Node;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KataTest {

    @Test
    public void reverse() {

        // Given
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.next = node2;
        Node node3 = new Node(3);
        node2.next = node3;

        // When
        Node newHead = Kata.reverse(node1);

        // Then
        assertThat(node3).isEqualTo(newHead);
        assertThat(node2).isEqualTo(node3.next);
        assertThat(node1).isEqualTo(node2.next);
        assertThat(node1.next).isNull();
    }
}
