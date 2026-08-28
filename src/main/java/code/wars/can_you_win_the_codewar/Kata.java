package code.wars.can_you_win_the_codewar;

import java.util.TreeMap;

import static java.util.Arrays.sort;

public class Kata {

    public static String codewarResult(int[] codewarrior, int[] opponent) {
        var cw = new TreeMap<Integer, Integer>();
        for (var v : codewarrior) {
            cw.merge(v, 1, Integer::sum);
        }

        var oppSorted = opponent.clone();
        sort(oppSorted);
        var oppUsed = new boolean[oppSorted.length];

        int wins = 0;
        int ties = 0;

        for (var i = oppSorted.length - 1; i >= 0; i--) {
            var winVal = cw.higherKey(oppSorted[i]);
            if (winVal != null) {
                wins++;
                decrement(cw, winVal);
                oppUsed[i] = true;
            }
        }

        for (var i = 0; i < oppSorted.length; i++) {
            if (oppUsed[i]) {
                continue;
            }
            if (cw.containsKey(oppSorted[i])) {
                ties++;
                decrement(cw, oppSorted[i]);
                oppUsed[i] = true;
            }
        }

        var loses = opponent.length - wins - ties;
        if (wins > loses) {
            return "Victory";
        }
        if (loses > wins) {
            return "Defeat";
        }
        return "Stalemate";
    }

    private static void decrement(TreeMap<Integer, Integer> map, int key) {
        var count = map.get(key) - 1;
        if (count == 0) {
            map.remove(key);
        } else {
            map.put(key, count);
        }
    }
}
