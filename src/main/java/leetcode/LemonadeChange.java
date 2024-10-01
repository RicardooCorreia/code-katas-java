package leetcode;

import java.util.LinkedList;
import java.util.List;

public class LemonadeChange {

    static class Solution {
        public boolean lemonadeChange(int[] bills) {
            int five = 0, ten = 0;

            for (int bill : bills) {
                if (bill == 5) {
                    five++;
                }
                else if (bill == 10) {
                    if (five == 0) return false;
                    five--;
                    ten++;
                }
                else {
                    if (ten > 0 && five > 0) {
                        ten--;
                        five--;
                    }
                    else if (five >= 3) {
                        five -= 3;
                    }
                    else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    static class Solution2 {
        public boolean lemonadeChange(int[] bills) {
            List<Integer> cashier = new LinkedList<>();

            for (int bill : bills) {
                addBillToCashier(cashier, bill);
                boolean canGive = giveChange(cashier, bill - 5);
                if (!canGive) {
                    return false;
                }
            }
            return true;
        }

        private void addBillToCashier(List<Integer> cashier, int bill) {
            if (cashier.isEmpty()) {
                cashier.add(bill);
            } else {
                for (int i = 0; i < cashier.size(); i++) {
                    if (bill > cashier.get(i)) {
                        cashier.add(i, bill);
                        return;
                    }
                }
                cashier.add(bill);
            }
        }

        private boolean giveChange(List<Integer> cashier, int change) {
            for (int i = 0; i < cashier.size() && change > 0; i++) {
                Integer bill = cashier.get(i);
                if (bill <= change) {
                    change -= bill;
                    cashier.remove(i);
                }
            }
            return change == 0;
        }
    }
}
