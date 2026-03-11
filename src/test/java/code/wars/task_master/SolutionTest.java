package code.wars.task_master;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    private static final Random RANDOM = new Random();

    private static Callable<Integer> getFunction(final long millis, final int result) {

        return () -> {
            Thread.sleep(millis);
            return result;
        };
    }

    @Test
    void taskMaster_whenTwoFunctions_returnSumOfResults() {

        // Given
        final List<Callable<Integer>> functions = List.of(
                getFunction(RANDOM.nextLong(1000, 2001), 3),
                getFunction(RANDOM.nextLong(1000, 2001), 2)
        );

        // When
        final int result = Solution.taskMaster(functions);

        // Then
        assertThat(result)
                .isEqualTo(5);
    }

    @Test
    void taskMaster_whenMultipleFunctionsWithSameResults_returnSumOfResults() {

        // Given
        final List<Callable<Integer>> functions = new ArrayList<>();
        final Callable<Integer> function = getFunction(RANDOM.nextLong(1000, 2001), 3);
        for (int i = 0; i < 10; i++) {
            functions.add(function);
        }

        // When
        final int result = Solution.taskMaster(List.copyOf(functions));

        // Then
        assertThat(result)
                .isEqualTo(30);
    }

    @Test
    void taskMaster_whenMultipleFunctionsWithDifferentResults_returnSumOfResults() {

        // Given
        final List<Callable<Integer>> functions = new ArrayList<>();
        final Callable<Integer> functionA = getFunction(RANDOM.nextLong(1000, 2001), 3);
        for (int i = 0; i < 10; i++) {
            functions.add(functionA);
        }
        final Callable<Integer> functionB = getFunction(RANDOM.nextLong(1000, 2001), 2);
        for (int i = 0; i < 10; i++) {
            functions.add(functionB);
        }

        // When
        final int result = Solution.taskMaster(List.copyOf(functions));

        // Then
        assertThat(result)
                .isEqualTo(50);
    }
}
