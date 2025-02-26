package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FinalValueOfVariableAfterPerformingOperationsTest {

    private final FinalValueOfVariableAfterPerformingOperations.Solution subject = new FinalValueOfVariableAfterPerformingOperations.Solution();

    @Test
    void finalValueAfterOperations_exampleOne() {

        // Given
        String[] operations = {"--X", "X++", "X++"};

        // When
        int result = subject.finalValueAfterOperations(operations);

        // Then
        assertThat(result)
                .isEqualTo(1);
    }

    @Test
    void finalValueAfterOperations_exampleTwo() {

        // Given
        String[] operations = {"++X", "++X", "X++"};

        // When
        int result = subject.finalValueAfterOperations(operations);

        // Then
        assertThat(result)
                .isEqualTo(3);
    }

    @Test
    void finalValueAfterOperations_exampleThree() {

        // Given
        String[] operations = {"X++", "++X", "--X", "X--"};

        // When
        int result = subject.finalValueAfterOperations(operations);

        // Then
        assertThat(result)
                .isEqualTo(0);
    }
}