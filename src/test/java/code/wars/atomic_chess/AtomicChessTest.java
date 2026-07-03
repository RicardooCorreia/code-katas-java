package code.wars.atomic_chess;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static code.wars.atomic_chess.AtomicChess.makeAtomicMove;
import static org.assertj.core.api.Assertions.assertThat;

class AtomicChessTest {

    @ParameterizedTest
    @MethodSource("whiteCaptureCases")
    void should_captureAndExplodeAdjacentPieces_when_whiteMakesCapture(char[][] board, String move, char[][] expected) {
        // given
        // input from MethodSource

        // when
        var result = makeAtomicMove(board, move);

        // then
        assertBoardEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("blackCaptureCases")
    void should_captureAndExplodeAdjacentPieces_when_blackMakesCapture(char[][] board, String move, char[][] expected) {
        // given
        // input from MethodSource

        // when
        var result = makeAtomicMove(board, move);

        // then
        assertBoardEquals(expected, result);
    }

    @Test
    void should_moveWithoutExplosion_when_moveIsNonCapture() {
        // given
        var board = new char[][]{
                {'.', '.', '.', '.', 'q', 'b', '.', 'k'},
                {'.', 'P', '.', 'r', 'p', '.', '.', 'P'},
                {'.', '.', '.', '.', 'r', 'q', '.', 'p'},
                {'.', '.', '.', '.', 'B', 'P', '.', '.'},
                {'.', 'P', 'p', '.', '.', '.', '.', '.'},
                {'.', 'Q', 'p', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', 'P', '.'},
                {'.', '.', '.', '.', '.', '.', 'K', '.'}
        };
        var move = "h8-g7";

        // when
            var result = makeAtomicMove(board, move);

        // then
        var expected = new char[][]{
                {'.', '.', '.', '.', 'q', 'b', '.', '.'},
                {'.', 'P', '.', 'r', 'p', '.', 'k', 'P'},
                {'.', '.', '.', '.', 'r', 'q', '.', 'p'},
                {'.', '.', '.', '.', 'B', 'P', '.', '.'},
                {'.', 'P', 'p', '.', '.', '.', '.', '.'},
                {'.', 'Q', 'p', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', 'P', '.'},
                {'.', '.', '.', '.', '.', '.', 'K', '.'}
        };
        assertBoardEquals(expected, result);
    }

    @Test
    void should_explodeAllAdjacentPieces_when_capturingInSurroundedPosition() {
        // given
        var board = new char[][]{
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', 'n', '.', '.', '.'},
                {'.', '.', 'N', 'r', 'q', 'k', '.', '.'},
                {'.', '.', '.', 'Q', 'n', 'b', '.', '.'},
                {'.', '.', '.', 'Q', 'b', 'N', '.', '.'},
                {'.', '.', '.', '.', 'R', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', 'K'}
        };
        var move = "c5xe4";

        // when
        var result = makeAtomicMove(board, move);

        // then
        var expected = new char[][]{
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', 'n', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', 'R', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', 'K'}
        };
        assertBoardEquals(expected, result);
    }

    private static Stream<Arguments> whiteCaptureCases() {
        return Stream.of(
                Arguments.of(new char[][]{
                        {'r', 'n', 'b', 'q', 'k', 'b', '.', 'r'},
                        {'p', 'p', 'p', '.', '.', 'p', 'p', 'p'},
                        {'.', '.', '.', 'p', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', 'N', '.', '.', '.'},
                        {'.', '.', '.', '.', 'P', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.'},
                        {'P', 'P', 'P', 'P', '.', 'P', 'P', 'P'},
                        {'R', 'N', 'B', 'Q', 'K', 'B', '.', 'R'}
                }, "e5xf7", new char[][]{
                        {'r', 'n', 'b', 'q', '.', '.', '.', 'r'},
                        {'p', 'p', 'p', '.', '.', '.', 'p', 'p'},
                        {'.', '.', '.', 'p', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', 'P', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.'},
                        {'P', 'P', 'P', 'P', '.', 'P', 'P', 'P'},
                        {'R', 'N', 'B', 'Q', 'K', 'B', '.', 'R'}
                }),
                Arguments.of(new char[][]{
                        {'r', 'n', 'b', 'q', 'k', 'b', '.', 'r'},
                        {'p', '.', 'p', '.', '.', 'p', 'p', 'p'},
                        {'.', '.', '.', 'p', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', 'p', '.', '.', '.'},
                        {'.', '.', '.', '.', 'P', '.', '.', '.'},
                        {'.', 'Q', '.', '.', '.', '.', '.', '.'},
                        {'P', 'P', 'P', '.', '.', 'P', 'P', 'P'},
                        {'R', 'N', 'B', '.', 'K', 'B', 'N', 'R'}
                }, "b3xb8", new char[][]{
                        {'.', '.', '.', 'q', 'k', 'b', '.', 'r'},
                        {'p', '.', 'p', '.', '.', 'p', 'p', 'p'},
                        {'.', '.', '.', 'p', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', 'p', '.', '.', '.'},
                        {'.', '.', '.', '.', 'P', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.'},
                        {'P', 'P', 'P', '.', '.', 'P', 'P', 'P'},
                        {'R', 'N', 'B', '.', 'K', 'B', 'N', 'R'}
                })
        );
    }

    private static Stream<Arguments> blackCaptureCases() {
        return Stream.of(
                Arguments.of(new char[][]{
                        {'.', '.', '.', '.', '.', '.', '.', 'k'},
                        {'.', 'B', '.', 'r', 'p', '.', '.', '.'},
                        {'.', 'p', '.', 'q', 'r', '.', '.', '.'},
                        {'.', '.', 'N', '.', '.', 'P', '.', '.'},
                        {'.', 'P', 'k', 'p', '.', 'b', '.', '.'},
                        {'.', '.', 'p', '.', 'B', '.', '.', '.'},
                        {'.', '.', '.', 'Q', 'P', '.', 'P', '.'},
                        {'.', '.', '.', '.', '.', 'K', '.', '.'}
                }, "e6xe3", new char[][]{
                        {'.', '.', '.', '.', '.', '.', '.', 'k'},
                        {'.', 'B', '.', 'r', 'p', '.', '.', '.'},
                        {'.', 'p', '.', 'q', '.', '.', '.', '.'},
                        {'.', '.', 'N', '.', '.', 'P', '.', '.'},
                        {'.', 'P', 'k', 'p', '.', '.', '.', '.'},
                        {'.', '.', 'p', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', 'P', '.', 'P', '.'},
                        {'.', '.', '.', '.', '.', 'K', '.', '.'}
                }),
                Arguments.of(new char[][]{
                        {'.', '.', '.', '.', '.', '.', '.', 'k'},
                        {'.', 'B', '.', 'r', 'p', '.', '.', '.'},
                        {'.', 'p', '.', 'q', 'r', '.', '.', '.'},
                        {'.', '.', 'N', '.', 'B', 'P', '.', '.'},
                        {'.', 'P', 'k', 'p', '.', '.', '.', '.'},
                        {'.', 'Q', 'p', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', 'P', '.', 'P', '.'},
                        {'.', '.', '.', '.', '.', '.', 'K', '.'}
                }, "b6xc5", new char[][]{
                        {'.', '.', '.', '.', '.', '.', '.', 'k'},
                        {'.', 'B', '.', 'r', 'p', '.', '.', '.'},
                        {'.', '.', '.', '.', 'r', '.', '.', '.'},
                        {'.', '.', '.', '.', 'B', 'P', '.', '.'},
                        {'.', 'P', '.', 'p', '.', '.', '.', '.'},
                        {'.', 'Q', 'p', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', 'P', '.', 'P', '.'},
                        {'.', '.', '.', '.', '.', '.', 'K', '.'}
                })
        );
    }

    private static void assertBoardEquals(char[][] expected, char[][] actual) {
        assertThat(actual).hasDimensions(expected[0].length, expected.length);
        for (var i = 0; i < expected.length; i++) {
            assertThat(actual[i]).containsExactly(expected[i]);
        }
    }
}