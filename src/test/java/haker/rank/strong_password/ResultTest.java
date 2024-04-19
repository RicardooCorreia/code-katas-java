package haker.rank.strong_password;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @Test
    void minimumNumber_whenMissingUpperCaseAndSpecialChar_return2() {

        // Given
        final String password = "2bbbb";

        // When
        final int result = Result.minimumNumber(5, password);

        // Then
        assertThat(result)
                .isEqualTo(2);
    }

    @Test
    void minimumNumber_whenIs5Length_return1() {

        // Given
        final String password = "2bb#A";

        // When
        final int result = Result.minimumNumber(5, password);

        // Then
        assertThat(result)
                .isEqualTo(1);
    }

    @Test
    void minimumNumber_whenIs3Length_return3() {

        // Given
        final String password = "Ab1";

        // When
        final int result = Result.minimumNumber(3, password);

        // Then
        assertThat(result)
                .isEqualTo(3);
    }

    @Test
    void minimumNumber_whenMissingNumber_return1() {

        // Given
        final String password = "#HackerRank";

        // When
        final int result = Result.minimumNumber(11, password);

        // Then
        assertThat(result)
                .isEqualTo(1);
    }
}