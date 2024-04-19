package code.wars.pair_of_shoes;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public static boolean pairOfShoes(Shoe[] shoes) {

        Map<Shoe, Integer> missingPairs = new HashMap<>();

        for (Shoe shoe : shoes) {
            Shoe otherShoe = shoe.other();
            Integer count = missingPairs.get(otherShoe);
            if (count == null || count == 0) {
                missingPairs.computeIfPresent(shoe, (shoe1, integer) -> integer + 1);
                missingPairs.putIfAbsent(shoe, 1);
            } else {
                missingPairs.computeIfPresent(otherShoe, (shoe1, integer) -> integer - 1);
            }
        }
        return missingPairs.values()
                .stream()
                .mapToInt(value -> value)
                .sum() == 0;
    }
}

enum Foot {
    LEFT,
    RIGHT;

    public Foot other() {

        if (LEFT.equals(this)) {
            return RIGHT;
        } else {
            return LEFT;
        }
    }
}

record Shoe(Foot foot, int size) {

    public Shoe other() {

        return new Shoe(foot.other(), size);
    }
}
