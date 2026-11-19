package code.wars.the_solar_system.jumbled_planets;

import java.util.Map;

import static java.util.Map.entry;

public class SolarSystem {

    private final Map<String, Integer> bodies = Map.ofEntries(
            entry("Asteroid", 1),
            entry("Pluto", 2),
            entry("Mercury", 3),
            entry("Mars", 4),
            entry("Venus", 5),
            entry("Earth", 6),
            entry("Neptune", 7),
            entry("Uranus", 8),
            entry("Saturn", 9),
            entry("Jupiter", 10));

    public char[] annotate(String[] celestialBodies) {

        if (celestialBodies == null || celestialBodies.length == 0) {
            return new char[0];
        }

        char[] result = new char[celestialBodies.length - 1];
        for (int i = 1; i < celestialBodies.length; i++) {

            String previousBody =  celestialBodies[i - 1];
            String currentBody =  celestialBodies[i];

            Integer currentBodyValue = bodies.get(currentBody);
            Integer previousBodyValue = bodies.get(previousBody);

            if (currentBodyValue > previousBodyValue) {
                result[i - 1] = '>';
            } else if  (currentBodyValue < previousBodyValue) {
                result[i - 1] = '<';
            } else {
                result[i - 1] = '=';
            }
        }
        return result;
    }
}
