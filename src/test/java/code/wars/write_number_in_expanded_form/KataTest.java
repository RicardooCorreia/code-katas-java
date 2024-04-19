package code.wars.write_number_in_expanded_form;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KataTest {

    @Test
    void expandedForm_when10PlusSomething_return10PlusOther() {

        // Given
        final int input = 12;

        // When
        final String result = Kata.expandedForm(input);


        // Then
        assertThat(result)
                .isEqualTo("10 + 2");
    }

    @Test
    void expandedForm_whenIsMultipleDozens_returnBaseDozenAndThenRest() {

        // Given
        final int input = 45;

        // When
        final String result = Kata.expandedForm(input);

        // Then
        assertThat(result)
                .isEqualTo("40 + 5");
    }

    @Test
    void expandedForm_whenIsLargeNumber_returnMultipleParts() {

        // Given
        final int input = 70304;

        // When
        final String result = Kata.expandedForm(input);

        // Then
        assertThat(result)
                .isEqualTo("70000 + 300 + 4");
    }

    @Test
    void expandedForm_whenIsSimpleNumber_returnNumber() {

        // Given
        final int input = 6;

        // When
        final String result = Kata.expandedForm(input);

        // Then
        assertThat(result)
                .isEqualTo("6");
    }

    @Test
    void expandedForm_whenIsRoundNumber_returnNumber() {

        // Given
        final int input = 8000;

        // When
        final String result = Kata.expandedForm(input);

        // Then
        assertThat(result)
                .isEqualTo("8000");
    }
}