package code.wars.number_of_trailing_zeros_of_n;

public class Solution {
    public static int zeros(int n) {

        if (n / 5 == 0)
            return 0;
        return n / 5 + zeros(n / 5);
    }
}
