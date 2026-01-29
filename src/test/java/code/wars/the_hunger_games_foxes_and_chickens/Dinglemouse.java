package code.wars.the_hunger_games_foxes_and_chickens;

import java.util.ArrayList;
import java.util.List;

public class Dinglemouse {

    public static String hungryFoxes(final String farm) {

        boolean fieldHasFox = false;
        Cage currentCage = new Cage();

        StringBuilder result = new StringBuilder();

        boolean inCage = false;
        for (char c : farm.toCharArray()) {
            if (c == '[') {
                inCage = true;
                currentCage = new Cage();
            } else if (c == ']') {
                inCage = false;
                getCageResult(result, currentCage);
            } else if (c == 'F') {
                if (inCage) {
                    currentCage.setHasFox(true);
                    currentCage.animals().add(c);
                } else {
                    fieldHasFox = true;
                    result.append(c);
                }
            } else {
                if (inCage) {
                    currentCage.animals().add(c);
                } else {
                    result.append(c);
                }
            }
        }

        if (fieldHasFox) {
            eatChickensInField(result);
        }

        return result.toString();
    }

    private static void eatChickensInField(StringBuilder result) {
        boolean inCage = false;
        char[] charArray = result.toString().toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c == '[') {
                inCage = true;
            } else if (c == ']') {
                inCage = false;
            } else if (!inCage) {
                if (c == 'C') {
                    result.setCharAt(i, '.');
                }
            }
        }
    }

    private static void getCageResult(StringBuilder result, Cage currentCage) {
        result.append("[");
        for (Character animal : currentCage.animals()) {
            if (animal == 'C' && currentCage.hasFox()) {
                result.append('.');
            } else {
                result.append(animal);
            }
        }
        result.append("]");
    }

    public static final class Cage {
        private boolean hasFox;
        private final List<Character> animals;

        public Cage() {
            animals = new ArrayList<>();
        }

        public boolean hasFox() {
            return hasFox;
        }

        public List<Character> animals() {
            return animals;
        }

        public void setHasFox(boolean hasFox) {
            this.hasFox = hasFox;
        }
    }
}
