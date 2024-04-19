package code.wars.will_you_survive_the_zombie_onslaught;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KataTest {

    @Test
    public void zombieShootout_whenShotAllZombies_returnAmount() {

        // Given
        int zombies = 3, range = 10, ammo = 10;

        // When
        final String result = Kata.zombieShootout(zombies, range, ammo);

        // Then
        assertThat(result).isEqualTo("You shot all 3 zombies.");
    }

    @Test
    public void zombieShootout_whenRangeFinished_returnOverwhelmed() {

        // Given
        int zombies = 100, range = 8, ammo = 200;

        // When
        final String result = Kata.zombieShootout(zombies, range, ammo);

        // Then
        assertThat(result).isEqualTo("You shot 16 zombies before being eaten: overwhelmed.");
    }

    @Test
    public void zombieShootout_whenAmmoFinished_returnOutOfAmmo() {

        // Given
        int zombies = 50, range = 10, ammo = 8;

        // When
        final String result = Kata.zombieShootout(zombies, range, ammo);

        // Then
        assertThat(result).isEqualTo("You shot 8 zombies before being eaten: ran out of ammo.");
    }
}
