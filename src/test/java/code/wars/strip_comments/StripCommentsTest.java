package code.wars.strip_comments;

import code.wars.sum_of_differences_in_array.strip_comments.StripComments;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StripCommentsTest {

    @Test
    void stripComments_whenHasMultipleLines_removeComments() {

        // Given
        final String input = "apples, pears # and bananas\ngrapes\nbananas !apples";
        final String[] commentSymbols = {"#", "!"};

        // When
        final String result = StripComments
                .stripComments(input, commentSymbols);

        // Then
        assertThat(result)
                .isEqualTo("apples, pears\ngrapes\nbananas");
    }

    @Test
    void stripComments_whenHasMultipleComments_removeAllComments() {

        // Given
        final String input = "a #b\nc\nd $e f g";
        final String[] commentSymbols = {"#", "$"};

        // When
        final String result = StripComments
                .stripComments(input, commentSymbols);

        // Then
        assertThat(result)
                .isEqualTo("a\nc\nd");
    }

    @Test
    void stripComments_whenHasTrailingSpaces_trimLines() {

        // Given
        final String input = "a    \nc    \nd    ";
        final String[] commentSymbols = {"#", "$"};

        // When
        final String result = StripComments
                .stripComments(input, commentSymbols);

        // Then
        assertThat(result)
                .isEqualTo("a\nc\nd");
    }

    @Test
    void stripComments_whenHasTrailingSpaces_trimLines2() {

        // Given
        final String input = "a\n[ ]b\nc    ";
        final String[] commentSymbols = {"#", "$"};

        // When
        final String result = StripComments
                .stripComments(input, commentSymbols);

        // Then
        assertThat(result)
                .isEqualTo("a\n[ ]b\nc");
    }
}
