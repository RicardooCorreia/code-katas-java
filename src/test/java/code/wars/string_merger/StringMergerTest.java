package code.wars.string_merger;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringMergerTest {

    @Test
    void isMerge_whenCanMerge_returnTrue() {

        // Given
        final String s = "codewars";
        final String part1 = "code";
        final String part2 = "wars";

        // When
        final boolean result = StringMerger.isMerge(s, part1, part2);

        // Then
        assertThat(result)
                .isTrue();
    }

    @Test
    void isMerge_whenCanMergeWithInterpolatedLetters_returnTrue() {

        // Given
        final String s = "codewars";
        final String part1 = "cdwr";
        final String part2 = "oeas";

        // When
        final boolean result = StringMerger.isMerge(s, part1, part2);

        // Then
        assertThat(result)
                .isTrue();
    }

    @Test
    void isMerge_whenMissingLetters_returnFalse() {

        // Given
        final String s = "codewars";
        final String part1 = "cod";
        final String part2 = "wars";

        // When
        final boolean result = StringMerger.isMerge(s, part1, part2);

        // Then
        assertThat(result)
                .isFalse();
    }

    @Test
    void isMerge_whenHasAllLettersButItsNotCorrectOrder_returnFalse() {

        // Given
        final String s = "codewars";
        final String part1 = "cdrw";
        final String part2 = "oesa";

        // When
        final boolean result = StringMerger.isMerge(s, part1, part2);

        // Then
        assertThat(result)
                .isFalse();
    }

    @Test
    void isMerge_whenHasToProcessTheSameCharacterInTheTwoStrings_returnFalse() {

        // Given
        final String s = "Can we merge it? Yes, we can!";
        final String part1 = "C wege itYe,wec!";
        final String part2 = "ane mr? s  an";

        // When
        final boolean result = StringMerger.isMerge(s, part1, part2);

        // Then
        assertThat(result)
                .isTrue();
    }

    @Test
    void isMerge_whenHasToProcessTheSameCharacterInTheTwoStrings2_returnFalse() {

        // Given
        final String s = "Can we merge it? Yes, we can!";
        final String part1 = "Cn e me t?es,we an!";
        final String part2 = "awergi Y c";

        // When
        final boolean result = StringMerger.isMerge(s, part1, part2);

        // Then
        assertThat(result)
                .isTrue();
    }

    @Test
    void isMerge_whenExtraCharsString_returnFalse() {

        // Given
        final String s = "codewars";
        final String part1 = "code";
        final String part2 = "warss";

        // When
        final boolean result = StringMerger.isMerge(s, part1, part2);

        // Then
        assertThat(result)
                .isFalse();
    }
}
