package other;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DifferenceKTest {

    @Test
    void diffExists_whenTheresDifference_returnTrue() {

        // Given
        DifferenceK subject = new DifferenceK();

        List<Integer> list = List.of(1, 9, 6, 4);
        int difference = 3;

        // When
        boolean result = subject.betterDiffExists(list, difference);

        // Then
        assertThat(result)
                .isTrue();
    }

    @Test
    void diffExists_whenTheresDifferenceButItsWithNegativeNumber_returnTrue() {

        // Given
        DifferenceK subject = new DifferenceK();

        List<Integer> list = List.of(-1, 2, 3, 4);
        int difference = 3;

        // When
        boolean result = subject.betterDiffExists(list, difference);

        // Then
        assertThat(result)
                .isTrue();
    }

    @Test
    void diffExists_whenTheresNoDifference_returnFalse() {

        // Given
        DifferenceK subject = new DifferenceK();

        List<Integer> list = List.of(5, 15, 10);
        int difference = 2;

        // When
        boolean result = subject.betterDiffExists(list, difference);

        // Then
        assertThat(result)
                .isFalse();
    }
}
