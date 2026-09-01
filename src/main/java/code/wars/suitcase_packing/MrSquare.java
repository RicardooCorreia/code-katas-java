package code.wars.suitcase_packing;

import static java.lang.Math.max;

public class MrSquare {
    public static Boolean fit_in(int a, int b, int m, int n) {
        final var combined = a + b;
        final var largerSquare = max(a, b);
        return (combined <= m && largerSquare <= n) || (combined <= n && largerSquare <= m);
    }
}
