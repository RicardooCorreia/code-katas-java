package code.wars.stalin_sort;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class SolutionTest {

    private void doTest(List<Integer> input, List<Integer> expected) {
        List<Integer> inputCopy = new ArrayList<>(input);
        Solution.stalinSort(inputCopy);
        assertIterableEquals(
            expected,
            inputCopy,
            String.format("Expected State of List to be %s,\nbut was %s", expected, inputCopy));
    }

    @Order(1)
    @DisplayName("Classic purge")
    @Test
    void classicPurge() {
        doTest(
            List.of(3, 1, 4, 1, 5, 9, 2),
            List.of(3, 4, 5, 9)
        );
    }

    @Order(2)
    @DisplayName("No purge needed")
    @Test
    void noPurge() {
        doTest(
            List.of(1, 2, 3),
            List.of(1, 2, 3)
        );
    }

    @Order(3)
    @DisplayName("Only first survives")
    @Test
    void onlyFirstSurvives() {
        doTest(
            List.of(5, 3, 1),
            List.of(5)
        );
    }

    @Order(4)
    @DisplayName("Empty List")
    @Test
    void emptyList() {
        doTest(
            List.of(),
            List.of()
        );
    }
}