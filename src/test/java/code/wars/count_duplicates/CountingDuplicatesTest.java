package code.wars.count_duplicates;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CountingDuplicatesTest {

    @Test
    public void duplicateCount_whenNoDuplicates_returnZero() {

        // Given
        final String input = "abcde";

        // When
        final int result = CountingDuplicates.duplicateCount(input);

        // Then
        assertThat(result)
                .isEqualTo(0);
    }

    @Test
    public void duplicateCount_when1Duplicate_returnOne() {

        // Given
        final String input = "abcdea";

        // When
        final int result = CountingDuplicates.duplicateCount(input);

        // Then
        assertThat(result)
                .isEqualTo(1);
    }

    @Test
    public void duplicateCount_when1DuplicateAppearingMultipleTimes_returnOne() {

        // Given
        final String input = "indivisibility";

        // When
        final int result = CountingDuplicates.duplicateCount(input);

        // Then
        assertThat(result)
                .isEqualTo(1);
    }

    @Test
    public void duplicateCount_whenReallyLongStringContainingDuplicates_returnsThree() {

        // Given
        final String testThousandA = new String(new char[1000]).replace('\0', 'a');
        final String testHundredB = new String(new char[100]).replace('\0', 'b');
        final String testTenC = new String(new char[10]).replace('\0', 'c');
        final String test1CapitalA = new String(new char[1]).replace('\0', 'A');
        final String test1d = new String(new char[1]).replace('\0', 'd');
        final String input = test1d + test1CapitalA + testTenC +
                testHundredB + testThousandA;

        // When
        final int result = CountingDuplicates.duplicateCount(input);

        // Then
        assertThat(result)
                .isEqualTo(3);
    }
}
