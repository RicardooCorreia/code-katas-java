package code.wars.two_fighters_one_winner;

import java.util.Objects;

public class Kata {
    public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {

        return Objects.equals(fighter1.name, firstAttacker) ? fight(fighter1, fighter2) : fight(fighter2, fighter1);
    }

    private static String fight(Fighter fighter1, Fighter fighter2) {

        int fighterHealth1 = fighter1.health;
        int fighterHealth2 = fighter2.health;
        while (fighterHealth1 > 0 && fighterHealth2 > 0) {
            fighterHealth1 -= fighter2.damagePerAttack;
            fighterHealth2 -= fighter1.damagePerAttack;
            System.out.println(fighter1.name + " has " + fighterHealth1 + " health!");
            System.out.println(fighter2.name + " has " + fighterHealth2 + " health!");
        }

        return fighterHealth2 <= 0 ? fighter1.name : fighter2.name;
    }

    public record Fighter(String name, int health, int damagePerAttack) {
    }
}
