package code.wars.number_of_people_in_the_bus;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class MetroTest {

    @Test
    public void countPassengers_returnTotalPassengers() {

        // Given
        ArrayList<int[]> list = new ArrayList<>();
        list.add(new int[]{10, 0});
        list.add(new int[]{3, 5});
        list.add(new int[]{2, 5});

        // When
        final int result = Metro.countPassengers(list);

        // Then
        assertThat(result)
                .isEqualTo(5);
    }
}
