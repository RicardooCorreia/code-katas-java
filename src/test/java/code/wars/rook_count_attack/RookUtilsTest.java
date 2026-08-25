package code.wars.rook_count_attack;

import static code.wars.rook_count_attack.RookUtils.countAttackingRooks;
import static java.lang.System.err;
import static java.util.Arrays.fill;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RookUtilsTest {

    @Test
    void should_returnTwo_when_threeRooksWithTwoAttacking() {
        // given
        int[][] rooks = {{2, 5}, {5, 3}, {5, 5}};

        // when
        int actual = countAttackingRooks(rooks);

        // then
        assertCount(2, actual, rooks);
    }

    @Test
    void should_returnFive_when_fiveRooksWithMultipleAttacks() {
        // given
        int[][] rooks = {{1, 3}, {1, 5}, {3, 5}, {5, 5}, {5, 3}};

        // when
        int actual = countAttackingRooks(rooks);

        // then
        assertCount(5, actual, rooks);
    }

    @Test
    void should_returnZero_when_rooksOnDiagonal() {
        // given
        int[][] rooks = {{0, 0}, {1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}, {6, 6}, {7, 7}};

        // when
        int actual = countAttackingRooks(rooks);

        // then
        assertCount(0, actual, rooks);
    }

    @Test
    void should_returnOne_when_twoRooksAttackEachOther() {
        // given
        int[][] rooks = {{1, 1}, {1, 6}};

        // when
        int actual = countAttackingRooks(rooks);

        // then
        assertCount(1, actual, rooks);
    }

    @Test
    void should_returnThree_when_fourRooksOnSameRow() {
        // given
        int[][] rooks = {{1, 1}, {1, 3}, {1, 5}, {1, 7}};

        // when
        int actual = countAttackingRooks(rooks);

        // then
        assertCount(3, actual, rooks);
    }

    @Test
    void should_returnOne_when_singleAttackingRook() {
        // given
        int[][] rooks = {{0, 0}, {2, 1}, {4, 2}, {6, 3}, {1, 5}, {3, 6}, {5, 7}, {7, 2}};

        // when
        int actual = countAttackingRooks(rooks);

        // then
        assertCount(1, actual, rooks);
    }

    @Test
    void should_returnFive_when_multipleAttackingRooks() {
        // given
        int[][] rooks = {{0, 0}, {0, 4}, {4, 4}, {4, 2}, {4, 0}};

        // when
        int actual = countAttackingRooks(rooks);

        // then
        assertCount(5, actual, rooks);
    }

    private void assertCount(int expected, int actual, int[][] rooks) {
        try {
            assertThat(actual).isEqualTo(expected);
        } catch (AssertionError e) {
            var board = new char[8][8];
            for (var row : board) fill(row, '.');
            for (var rook : rooks) board[rook[0]][rook[1]] = 'R';
            for (var row : board) err.println(new String(row));
            throw e;
        }
    }
}
