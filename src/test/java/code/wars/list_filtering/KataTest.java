package code.wars.list_filtering;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class KataTest {

    @Test
    public void filterList() {

        // Given
        final List<Object> input = List.of(1, 2, "aasf", "1", "123", 123);

        // When
        final List<Object> result = Kata.filterList(input);

        // Then
        assertThat(result)
                .isEqualTo(List.of(1, 2, 123));
    }
}
