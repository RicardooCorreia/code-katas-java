package haker.rank.day_of_the_programmer;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @Test
    public void dayOfProgrammer_whenIsNotLeapYear_return13of09() {

        // Given
        final int source = 2017;

        // When
        final String result = Result.dayOfProgrammer(source);

        // Then
        assertThat(result)
                .isEqualTo("13.09.2017");
    }

    @Test
    public void dayOfProgrammer_whenIsLeapYear_return12of09() {

        // Given
        final int source = 2016;

        // When
        final String result = Result.dayOfProgrammer(source);

        // Then
        assertThat(result)
                .isEqualTo("12.09.2016");
    }

    @Test
    public void dayOfProgrammer_whenIsLeapYearBeforeChangeYear_return12of09of1800() {

        // Given
        final int source = 1800;

        // When
        final String result = Result.dayOfProgrammer(source);

        // Then
        assertThat(result)
                .isEqualTo("12.09.1800");
    }

    @Test
    public void dayOfProgrammer_whenIsChangeYear_returnSpecialDate() {

        // Given
        final int source = 1918;

        // When
        final String result = Result.dayOfProgrammer(source);

        // Then
        assertThat(result)
                .isEqualTo("26.09.1918");
    }
}