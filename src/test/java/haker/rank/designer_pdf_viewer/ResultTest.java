package haker.rank.designer_pdf_viewer;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @Test
    void designerPdfViewer_whenIsABC_return9() {

        // Given
        final List<Integer> heights = List.of(1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5);
        final String word = "abc";

        // When
        final int result = Result.designerPdfViewer(heights, word);

        // Then
        assertThat(result)
                .isEqualTo(9);
    }

    @Test
    void designerPdfViewer_whenIsZABA_return28() {

        // Given
        final List<Integer> heights = List.of(1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7);
        final String word = "zaba";

        // When
        final int result = Result.designerPdfViewer(heights, word);

        // Then
        assertThat(result)
                .isEqualTo(28);
    }
}