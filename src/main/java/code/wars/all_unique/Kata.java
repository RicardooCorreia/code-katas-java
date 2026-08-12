package code.wars.all_unique;

import java.util.HashSet;
import java.util.Set;

public class Kata {

    public static boolean hasUniqueChars(String str) {
        Set<Character> set = new HashSet<>();
        for (var c : str.toCharArray()) {
            if (set.contains(c)) {
                return false;
            } else {
                set.add(c);
            }
        }
        return true;
    }
}
