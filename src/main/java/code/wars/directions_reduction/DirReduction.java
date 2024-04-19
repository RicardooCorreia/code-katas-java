package code.wars.directions_reduction;

import java.util.Map;
import java.util.Stack;

public class DirReduction {

    private static final String NORTH = "NORTH";
    private static final String SOUTH = "SOUTH";
    private static final String WEST = "WEST";
    private static final String EAST = "EAST";

    private static final Map<String, String> opposites = Map.of(
        NORTH, SOUTH,
        SOUTH, NORTH,
        WEST, EAST,
        EAST, WEST
    );

    public static String[] dirReduc(String[] arr) {

        Stack<String> directions = new Stack<>();

        for (String direction : arr) {
            String opposite = opposites.get(direction);
            if (!directions.isEmpty() && directions.peek().equals(opposite)) {
                directions.pop();
            } else {
                directions.push(direction);
            }
        }
        return directions.toArray(new String[0]);
    }
}
