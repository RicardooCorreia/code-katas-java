package code.wars.help_suzuki_rake_his_garden;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KataTest {

    @Test
    public void rakeGarden_thenReplaceEverythingThatsNotRockOrGravel() {

        // Given
        final String input = "slug spider rock gravel gravel gravel gravel gravel gravel gravel";

        // When
        final String result = Kata.rakeGarden(input);

        // Then
        assertEquals("gravel gravel rock gravel gravel gravel gravel gravel gravel gravel", result);
    }
}
