package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ReformatDateTest {

    private static ReformatDate.Solution subject = new ReformatDate.Solution();

    @ParameterizedTest
    @CsvSource({
            "20th Oct 2052, 2052-10-20",
            "6th Jun 1933, 1933-06-06",
            "26th May 1960, 1960-05-26"
    })
    void reformatDate(
            // Given
            String date,
            String expected) {

        // When
        String result = subject.reformatDate(date);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}