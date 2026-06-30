package code.wars.save_the_spice_harvester;

import static java.lang.Math.sqrt;

public class Save {

    public static String harvesterRescue(final int[][] data) {

        Location spiceHarvesterLocation = new Location(data[0][0], data[0][1]);

        Location wormLocation = new Location(data[1][0], data[1][1]);
        int wormSpeed = data[1][2];

        Location carryAllLocation = new Location(data[2][0], data[2][1]);
        int carryAllSpeed = data[2][2];

        double wormReachTime = wormLocation.distanceTo(spiceHarvesterLocation) / wormSpeed;
        double carryAllReachTime = carryAllLocation.distanceTo(spiceHarvesterLocation) / carryAllSpeed;

        return carryAllReachTime + 1 < wormReachTime
               ? "The spice must flow! Rescue the harvester!"
               : "Damn the spice! I'll rescue the miners!";
    }

    public record Location(int x, int y) {

        double distanceTo(Location other) {
            return sqrt((other.y() - this.y()) * (other.y() - this.y()) + (other.x() - this.x()) * (other.x() - this.x()));
        }
    }
}
