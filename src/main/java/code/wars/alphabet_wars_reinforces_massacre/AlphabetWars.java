package code.wars.alphabet_wars_reinforces_massacre;

import java.util.*;

public class AlphabetWars {

    public static String reinforcesMassacre(String[] reinforces, String[] airstrikes) {

        StringBuilder currentForces = new StringBuilder(reinforces[0]);
        List<List<Character>> backup = alignBackup(reinforces, currentForces);
        for (String airstrike : airstrikes) {
            handleAirstrike(airstrike, backup, currentForces);
        }
        return currentForces.toString();
    }

    private static void handleAirstrike(String airstrike, List<List<Character>> backup, StringBuilder currentForces) {
        Set<Integer> hits = new HashSet<>();
        for (int i = 0; i < airstrike.length(); i++) {
            char c = airstrike.charAt(i);
            if (c == '*') { // bomb
                int left = i - 1;
                if (left >= 0) {
                    hits.add(left);
                }

                hits.add(i);
                int right = i + 1;
                if (right < currentForces.length()) {
                    hits.add(right);
                }
            }
        }

        for (Integer hit : hits) {
            currentForces.setCharAt(hit, getReinforcement(backup, hit));
        }
    }

    private static Character getReinforcement(List<List<Character>> backup, int i) {
        List<Character> backupLine = backup.get(i);
        if (!backupLine.isEmpty()) {
            return backupLine.removeFirst();
        } else {
            return '_';
        }
    }

    private static List<List<Character>> alignBackup(String[] reinforces, StringBuilder currentForces) {
        List<List<Character>> backup = new ArrayList<>(reinforces.length);
        for (int i = 0; i < currentForces.length(); i++) {
            backup.add(new LinkedList<>());
        }

        for (int i = 1; i < reinforces.length; i++) {
            for (int j = 0; j < reinforces[i].length(); j++) {
                char soldier = reinforces[i].charAt(j);
                backup.get(j).add(soldier);
            }
        }
        return backup;
    }
}
