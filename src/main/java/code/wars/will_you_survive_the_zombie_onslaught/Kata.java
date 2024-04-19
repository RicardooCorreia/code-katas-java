package code.wars.will_you_survive_the_zombie_onslaught;

public class Kata {

    public static String zombieShootout(int zombies, int range, int ammo) {

        float currentDistance = range;
        int currentZombies = zombies;
        int currentAmmo = ammo;
        int zombieShot = 0;
        while (currentDistance > 0 && currentZombies > 0 && currentAmmo > 0) {

            currentZombies--;
            zombieShot++;
            currentAmmo--;

            currentDistance-=0.5;
        }

        if (currentDistance == 0 && currentZombies > 0) {
            return String.format("You shot %s zombies before being eaten: overwhelmed.", zombieShot);
        } else if (currentAmmo == 0 && currentZombies > 0) {
            return String.format("You shot %s zombies before being eaten: ran out of ammo.", zombieShot);
        } else {
            return String.format("You shot all %s zombies.", zombieShot);
        }
    }
}
