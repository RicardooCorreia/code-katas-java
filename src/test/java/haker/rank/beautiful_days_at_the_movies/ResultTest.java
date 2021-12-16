package haker.rank.beautiful_days_at_the_movies;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @Test
    void beautifulDays_whenHas2BeautifulDays_return2() {

        // Given
        final int startRange = 20;
        final int endRange = 23;
        final int divisor = 6;

        // When
        final int result = Result.beautifulDays(startRange, endRange, divisor);

        // Then
        assertThat(result)
                .isEqualTo(2);
    }

    @Test
    void beautifulDays_whenHasManyBeautifulDays_returnCorrectDays() {

        // Given
        final int startRange = 13;
        final int endRange = 45;
        final int divisor = 3;

        // When
        final int result = Result.beautifulDays(startRange, endRange, divisor);

        // Then
        assertThat(result)
                .isEqualTo(33);
    }

    @Test
    void beautifulDays_whenHasManyBeautifulDays_returnCorrectDays2() {

        // Given
        final int startRange = 49860;
        final int endRange = 205494;
        final int divisor = 155635764;

        // When
        final int result = Result.beautifulDays(startRange, endRange, divisor);

        // Then
        assertThat(result)
                .isEqualTo(607);
    }

    @Test
    void beautifulDays_whenHasManyBeautifulDays_returnCorrectDays3() {

        // Given
        final int startRange = 819945;
        final int endRange = 946749;
        final int divisor = 8946432;

        // When
        final int result = Result.beautifulDays(startRange, endRange, divisor);

        // Then
        assertThat(result)
                .isEqualTo(127);
    }
}