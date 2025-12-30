package code.wars.transforming_chess_piece;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TransformingChessPieceTest {

    @Test
    @DisplayName("Case 1 - No Captures")
    void testCase1() {

        // Given
        final char[][] board = {
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', 'B', '.', 'R'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', 'Q', '.', '.'},
                {'.', '.', '.', 'N', '.', '.', '.', '.'},
                {'P', '.', '.', '.', '.', '.', '.', '.'},
                {'.', 'K', '.', '.', '.', '.', '.', '.'}
        };

        // When
        List<Character> result = TransformingChessPiece.capturePieces(board, 'B');

        // Then
        assertThat(result)
                .isEqualTo(List.of('B', 'K', 'N', 'P', 'Q', 'R'));
    }

    @Test
    @DisplayName("Case 2 - One Capture")
    void testCase2() {

        // Given
        final char[][] board = {
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', 'B', '.', 'R'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', 'Q', '.', '.'},
                {'.', '.', '.', 'N', '.', '.', '.', '.'},
                {'P', '.', '.', '.', '.', '.', '.', '.'},
                {'.', 'K', '.', '.', '.', '.', '.', '.'}
        };

        // When
        List<Character> result = TransformingChessPiece.capturePieces(board, 'K');

        // Then
        assertThat(result)
                .isEqualTo(List.of('B', 'N', 'P', 'Q', 'R'));
    }

    @Test
    @DisplayName("Case 3 - Two Captures")
    void testCase3() {

        // Given
        final char[][] board = {
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', 'B', '.', 'R'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'N', '.', 'Q', '.', '.'},
                {'P', 'K', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}
        };

        // When
        List<Character> result = TransformingChessPiece.capturePieces(board, 'N');

        // Then
        assertThat(result)
                .isEqualTo(List.of('B', 'P', 'Q', 'R'));
    }

    @Test
    @DisplayName("Case 4 - Three Captures")
    void testCase4() {

        // Given
        final char[][] board = {
                {'.', '.', '.', '.', 'R', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', 'K', '.', '.', 'N', '.', '.', '.'},
                {'B', '.', 'P', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'Q', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}
        };

        // When
        List<Character> result = TransformingChessPiece.capturePieces(board, 'Q');

        // Then
        assertThat(result)
                .isEqualTo(List.of('N', 'P', 'R'));
    }

    @Test
    @DisplayName("Case 5 - Four Captures")
    void testCase5() {

        // Given
        final char[][] board = {
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', 'B', 'R'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', 'Q', '.', '.'},
                {'.', '.', '.', 'N', '.', '.', '.', '.'},
                {'P', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', 'K', '.', '.'}
        };

        // When
        List<Character> result = TransformingChessPiece.capturePieces(board, 'R');

        // Then
        assertThat(result)
                .isEqualTo(List.of('K', 'P'));
    }

    @Test
    @DisplayName("Case 6 - Five Captures")
    void testCase6() {

        // Given
        final char[][] board = {
                {'.', '.', '.', '.', 'R', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', 'K', '.', '.', 'N', '.', '.', '.'},
                {'B', '.', 'P', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'Q', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}
        };

        // When
        List<Character> result = TransformingChessPiece.capturePieces(board, 'R');

        // Then
        assertThat(result)
                .isEqualTo(List.of('Q'));
    }

    @Test
    @DisplayName("Case 7 - Five Captures")
    void testCase7() {

        // Given
        final char[][] board = {
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', 'Q', '.', '.', '.', '.', '.', 'R'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'B', '.', '.', '.', '.'},
                {'.', 'N', '.', '.', '.', '.', '.', '.'},
                {'.', 'K', '.', '.', '.', '.', '.', '.'},
                {'P', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}
        };

        // When
        List<Character> result = TransformingChessPiece.capturePieces(board, 'P');

        // Then
        assertThat(result)
                .isEqualTo(List.of('R'));
    }

    @Test
    @DisplayName("Case 8 - Five Captures")
    void testCase8() {

        // Given
        final char[][] board = {
                {'.', '.', '.', '.', '.', '.', 'N', 'Q'},
                {'.', '.', '.', '.', '.', '.', '.', 'R'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', 'K', '.', '.', '.', '.', '.', '.'},
                {'P', 'B', '.', '.', '.', '.', '.', '.'}
        };

        // When
        List<Character> result = TransformingChessPiece.capturePieces(board, 'P');

        // Then
        assertThat(result)
                .isEqualTo(List.of('N'));
    }

    @Test
    @DisplayName("Case 9")
    void testCase9() {

        // Given
        final char[][] board = {
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'B', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', 'N', '.', '.', '.'},
                {'.', 'K', '.', '.', '.', '.', '.', 'R'},
                {'.', '.', '.', '.', '.', 'Q', 'P', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}
        };

        // When
        List<Character> result = TransformingChessPiece.capturePieces(board, 'N');

        // Then
        assertThat(result)
                .isEqualTo(List.of('B', 'K'));
    }
}
