package code.wars.sum_of_numbers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SumTest {

    private final Sum subject = new Sum();

    @Test
    public void getSum_sumsNumbers() {

        // Given
        final int a = 2;
        final int b = 1;

        // When
        final int result = subject.getSum(a, b);

        // Then
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void getSum_whenNegative_sumsNumbers() {

        // Given
        final int a = -2;
        final int b = 0;

        // When
        final int result = subject.getSum(a, b);

        // Then
        assertThat(result).isEqualTo(-3);
    }

    @Test
    public void getSum_whenEqual_returnSame() {

        // Given
        final int a = 5;
        final int b = 5;

        // When
        final int result = subject.getSum(a, b);

        // Then
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void getSum_whenBiggerGap_returnSum() {

        // Given
        final int a = -1;
        final int b = 2;

        // When
        final int result = subject.getSum(a, b);

        // Then
        assertThat(result).isEqualTo(2);
    }
}
