package haker.rank.viral_advertising;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @Test
    void viralAdvertising_whenNoIteration_return0() {

        // Given
        final int input = 0;

        // When
        final int result = Result.viralAdvertising(input);

        // Then
        assertThat(result)
                .isEqualTo(0);
    }

    @Test
    void viralAdvertising_whenThreeDays_returnNinePeople() {

        // Given
        final int input = 3;

        // When
        final int result = Result.viralAdvertising(input);

        // Then
        assertThat(result)
                .isEqualTo(9);
    }

    @Test
    void viralAdvertising_when4Days_return15People() {

        // Given
        final int input = 4;

        // When
        final int result = Result.viralAdvertising(input);

        // Then
        assertThat(result)
                .isEqualTo(15);
    }

    @Test
    void viralAdvertising_whenOneDay_returnTwoPeople() {

        // Given
        final int input = 1;

        // When
        final int result = Result.viralAdvertising(input);

        // Then
        assertThat(result)
                .isEqualTo(2);
    }
}