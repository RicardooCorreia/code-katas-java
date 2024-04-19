package code.wars.return_1_2_3_random;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class MainTest {

    private static int count = 60_000;
    private static double threshold = 0.005;
    private static int[] results = new int[count];
    private static Set<Integer> setResults = new HashSet<>();

    @BeforeAll
    public static void beforeClass() {

        for (int i = 0; i < count; i++) {
            results[i] = Main.oneTwoThree();
            setResults.add(results[i]);
        }
    }

    @Test
    public void testOneTwoThreeMustBePresent() {
        assertThat(setResults.contains(1)).isTrue();
        assertThat(setResults.contains(2)).isTrue();
        assertThat(setResults.contains(3)).isTrue();
    }

    @Test
    public void testShouldNotContainInvalidNumbers() {
        assertThat(setResults.size()).isEqualTo(3);
    }

    @Test
    public void testAllNumbersMustBePresentsWithEqualProbability() {
        assertThat(numberOfResultHasProbability(1, 1.0 / 3)).isTrue();
        assertThat(numberOfResultHasProbability(2, 1.0 / 3)).isTrue();
        assertThat(numberOfResultHasProbability(3, 1.0 / 3)).isTrue();
    }

    private boolean numberOfResultHasProbability(int number, double probability) {
        return (countOf(number) * 1.0 / count) - probability < threshold;
    }

    private long countOf(int number) {
        return Arrays.stream(results).filter(n -> n == number).count();
    }
}
