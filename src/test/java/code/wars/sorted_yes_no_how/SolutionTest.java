package code.wars.sorted_yes_no_how;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    public void test1() {
        int[] array = new int[] {1, 2};
        assertThat(Solution.isSortedAndHow(array)).isEqualTo("yes, ascending");
    }

    @Test
    public void test2() {
        int[] array = new int[] {15, 7, 3, -8};
        assertThat(Solution.isSortedAndHow(array)).isEqualTo("yes, descending");
    }

    @Test
    public void test3() {
        int[] array = new int[] {4, 2, 30};
        assertThat(Solution.isSortedAndHow(array)).isEqualTo("no");
    }
}
