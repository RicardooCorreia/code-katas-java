package code.wars.counting_sheep;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CounterTest {

    @Test
    public void countSheeps() {

        // Given
        Boolean[] array1 = {true, true, true, false,
                true, true, true, true,
                true, false, true, false,
                true, false, false, true,
                true, true, true, true,
                false, false, true, true};

        // When
        final int result = new Counter().countSheeps(array1);

        // Then
        assertThat(result)
                .isEqualTo(17);
    }
}
