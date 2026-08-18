package code.wars.battle_of_the_characters;

public class BattleOfTheCharacters {

    public static String battle(String first, String second) {

        int firstPower = powerOf(first);
        int secondPower = powerOf(second);

        if (firstPower > secondPower) {
            return first;
        } else if (firstPower < secondPower) {
            return second;
        } else {
            return "Tie!";
        }
    }

    private static int powerOf(String string) {
        return string.chars()
            .map(c -> c - 'A' + 1)
            .sum();
    }
}
