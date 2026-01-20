package code.wars.string_searching_with_wildcard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SearchEngineTest {

    private static final String HAYSTACK = "Once upon a midnight dreary, while I pondered, weak and weary";

    @Test
    void find_whenSearchingAtBeginning_returnZero() {

        // Given
        final String needle = "Once";

        // When
        final int result = SearchEngine.find(needle, HAYSTACK);

        // Then
        assertThat(result)
                .isEqualTo(0);
    }

    @Test
    void find_whenSearchingForMidnight_returnCorrectPosition() {

        // Given
        final String needle = "midnight";

        // When
        final int result = SearchEngine.find(needle, HAYSTACK);

        // Then
        assertThat(result)
                .isEqualTo(12);
    }

    @Test
    void find_whenWordNotFound_returnMinusOne() {

        // Given
        final String needle = "codewars";

        // When
        final int result = SearchEngine.find(needle, HAYSTACK);

        // Then
        assertThat(result)
                .isEqualTo(-1);
    }

    @Test
    void find_whenUsingWildcardAtBeginningAndEnd_returnCorrectPosition() {

        // Given
        final String needle = "_po_";

        // When
        final int result = SearchEngine.find(needle, HAYSTACK);

        // Then
        assertThat(result)
                .isEqualTo(5);
    }

    @Test
    void find_whenUsingMultipleWildcardsAtBeginning_returnCorrectPosition() {

        // Given
        final String needle = "___night";

        // When
        final int result = SearchEngine.find(needle, HAYSTACK);

        // Then
        assertThat(result)
                .isEqualTo(12);
    }

    @Test
    void find_whenOutOfBounds_doesNotThrowException() {

        // Given
        final String needle = "weary___";

        // When
        final int result = SearchEngine.find(needle, HAYSTACK);

        // Then
        assertThat(result)
                .isEqualTo(-1);
    }
}
