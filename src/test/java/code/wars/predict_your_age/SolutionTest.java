package code.wars.predict_your_age;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    public void predictAge() {

        // Given
        final int age1 = 65;
        final int age2 = 60;
        final int age3 = 75;
        final int age4 = 55;
        final int age5 = 60;
        final int age6 = 63;
        final int age7 = 64;
        final int age8 = 45;

        // When
        final int result = Solution.predictAge(age1, age2, age3, age4, age5, age6, age7, age8);

        // Then
        assertThat(result).isEqualTo(86);
    }
}
