package haker.rank.fair_rations;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @Test
    void fairRations_whenFourLoafsAreRequired_returnLoafs() {

        // Given
        final List<Integer> people = List.of(4, 5, 6, 7);

        // When
        final String result = Result.fairRations(people);

        // Then
        assertThat(result)
                .isEqualTo("4");
    }

    @Test
    void fairRations_whenFourLoafsAreRequiredWithMorePeople_returnLoafs() {

        // Given
        final List<Integer> people = List.of(2, 3, 4, 5, 6);

        // When
        final String result = Result.fairRations(people);

        // Then
        assertThat(result)
                .isEqualTo("4");
    }

    @Test
    void fairRations_whenItsNotPossible_returnNo() {

        // Given
        final List<Integer> people = List.of(1, 2);

        // When
        final String result = Result.fairRations(people);

        // Then
        assertThat(result)
                .isEqualTo("NO");
    }

    @Test
    void fairRations_whenItsRequired6Loafs_return6Loafs() {

        // Given
        final List<Integer> people = List.of(1, 2, 3, 7, 7);

        // When
        final String result = Result.fairRations(people);

        // Then
        assertThat(result)
                .isEqualTo("6");
    }
}