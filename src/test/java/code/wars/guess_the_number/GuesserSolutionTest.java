package code.wars.guess_the_number;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GuesserSolutionTest {

    @Test
    public void getNumber_returnAnswer() {

        // Given
        GuesserSolution subject = new GuesserSolution();
        final int expected = 42;
        subject.setAnswer(expected);

        // When
        int result = subject.getNumber();

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }

    @Test
    public void getNumber_whenUpperLimit_returnAnswer() {

        // Given
        GuesserSolution subject = new GuesserSolution();
        final int expected = 1000;
        subject.setAnswer(expected);

        // When
        int result = subject.getNumber();

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }

    @Test
    public void getNumber_whenLowerLimit_returnAnswer() {

        // Given
        GuesserSolution subject = new GuesserSolution();
        final int expected = 0;
        subject.setAnswer(expected);

        // When
        int result = subject.getNumber();

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }

    @Test
    public void getNumber_whenOtherLowerLimit_returnAnswer() {

        // Given
        GuesserSolution subject = new GuesserSolution();
        final int expected = 249;
        subject.setAnswer(expected);

        // When
        int result = subject.getNumber();

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }

    @Test
    public void getNumber_whenOtherUpperLimit_returnAnswer() {

        // Given
        GuesserSolution subject = new GuesserSolution();
        final int expected = 251;
        subject.setAnswer(expected);

        // When
        int result = subject.getNumber();

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}
