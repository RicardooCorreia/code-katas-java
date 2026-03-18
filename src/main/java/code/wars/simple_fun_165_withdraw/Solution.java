package code.wars.simple_fun_165_withdraw;

/*
Task
An ATM ran out of 10 dollar bills and only has 100, 50 and 20 dollar bills.

Given an amount between 40 and 10000 dollars (inclusive) and assuming that the ATM wants to use as few bills as possible,
 determinate the minimal number of 100, 50 and 20 dollar bills the ATM needs to dispense (in that order).

Example
For n = 250, the result should be [2, 1, 0].

For n = 260, the result should be [2, 0, 3].

For n = 370, the result should be [3, 1, 1].

Input/Output
[input] integer n Amount of money to withdraw. Assume that n is always exchangeable with [100, 50, 20] bills.
[output] integer array An array of number of 100, 50 and 20 dollar bills needed to complete the withdraw (in that order).
 */
public class Solution {

    public static final int HUNDRED = 100;
    public static final int FIFTY = 50;
    public static final int TWENTY = 20;

    public static int[] withdraw(int amount) {
        int bill100 = 0,
                bill50 = 0,
                bill20 = 0;

        while (amount > 0) {
            if (amount % HUNDRED == 0) {
                amount -= HUNDRED;
                bill100++;
            } else if (amount % FIFTY == 0) {
                amount -= FIFTY;
                bill50++;
            } else {
                amount -= TWENTY;
                bill20++;
            }
        }
        return new int[]{bill100, bill50, bill20};
    }
}
