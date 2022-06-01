package code.wars.atm;

import java.util.List;

public class ATM {

    private final List<Integer> BANKNOTES = List.of(500, 200, 100, 50, 20, 10);

    public int solve(int n) {

        int count = 0;
        int remainingAmount = n;
        for (Integer banknote : BANKNOTES) {
            while (banknote <= remainingAmount) {
                remainingAmount -= banknote;
                count++;
            }
        }

        if (remainingAmount != 0) return -1;

        return count;
    }
}
