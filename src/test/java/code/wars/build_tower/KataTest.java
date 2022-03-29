package code.wars.build_tower;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class KataTest {

    @Test
    public void towerBuilder_when1Floor_returnTower() {

        // Given
        final int nFloors = 1;

        // When
        final String[] result = Kata.towerBuilder(nFloors);

        // Then
        assertThat(result)
                .isEqualTo(new String[]{"*"});
    }

    @Test
    public void towerBuilder_when2Floor_returnTower() {

        // Given
        final int nFloors = 2;

        // When
        final String[] result = Kata.towerBuilder(nFloors);

        // Then
        assertThat(result)
                .isEqualTo(new String[]{" * ", "***"});
    }

    @Test
    public void towerBuilder_when3Floor_returnTower() {

        // Given
        final int nFloors = 3;

        // When
        final String[] result = Kata.towerBuilder(nFloors);

        // Then
        assertThat(result)
                .isEqualTo(new String[]{"  *  ", " *** ", "*****"});
    }
}
