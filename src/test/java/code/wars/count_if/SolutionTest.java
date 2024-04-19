package code.wars.count_if;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void countIf_whenNull_returnFalse() {

        // Given
        Node<Object> input = null;

        // When
        int result = Solution.countIf(input, __ -> false);

        // Then
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void countIf_whenTrue_countEveryone() {

        // Given
        Node<Integer> three = new Node<>(3);
        Node<Integer> two = new Node<>(2, three);
        Node<Integer> one = new Node<>(1, two);

        // When
        int result = Solution.countIf(one, __ -> true);

        // Then
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void countIf_whenConditional_countSome() {

        // Given
        Node<Integer> three = new Node<>(3);
        Node<Integer> two = new Node<>(2, three);
        Node<Integer> one = new Node<>(1, two);

        // When
        int result = Solution.countIf(one, x -> x <= 2);

        // Then
        assertThat(result).isEqualTo(2);
    }
}
