package code.wars.street_fighter_character_selection;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public static String[] streetFighterSelection(String[][] fighters, int[] position, String[] moves) {

        int x = position[0];
        int y = position[1];
        List<String> characters = new LinkedList<>();
        for (String move : moves) {

            switch (move) {
                case "left" -> x--;
                case "right" -> x++;
                case "up" -> y--;
                case "down" -> y++;
            }

            if (x < 0) {
                x = fighters[0].length - 1;
            } else if (x >= fighters[0].length) {
                x = 0;
            }

            if (y < 0) {
                y = 0;
            } else if (y >= fighters.length) {
                y = fighters.length - 1;
            }
            characters.add(fighters[y][x]);
        }
        return characters.toArray(String[]::new);
    }
}
