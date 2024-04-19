package haker.rank.cavity_map;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @Test
    void cavityMap_whenThereIsJustOneCavity_returnReplaced() {

        // Given
        final List<String> grid = List.of("989", "191", "111");

        // When
        final List<String> result = Result.cavityMap(grid);

        // Then
        assertThat(result)
                .containsExactly("989", "1X1", "111");
    }

    @Test
    void cavityMap_whenThereIsMultipleCavity_returnReplaced() {

        // Given
        final List<String> grid = List.of("1112", "1912", "1892", "1234");

        // When
        final List<String> result = Result.cavityMap(grid);

        // Then
        assertThat(result)
                .containsExactly("1112", "1X12", "18X2", "1234");
    }
}