package haker.rank.camel_case;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @Test
    void camelCase_whenHasMultipleWords_returnCount() {

        // Given
        final String input = "saveChangesInTheEditor";

        // When
        final int result = Result.camelcase(input);

        // Then
        assertThat(result)
                .isEqualTo(5);
    }

    @Test
    void camelCase_whenHasSingleWord_returnOne() {

        // Given
        final String input = "one";

        // When
        final int result = Result.camelcase(input);

        // Then
        assertThat(result)
                .isEqualTo(1);
    }
}