package code.wars.find_last_fibonacci_digit;

class Kata {

    static int lastFibDigit(int n) {
        if (n <= 0) return 0;

        n = n % 60; // The last digit repeats every 60 numbers
        if (n == 0) return 0;

        int a = 0;
        int b = 1;
        for (int i = 2; i <= n; i++) {
            int sum = (a + b) % 10;
            a = b;
            b = sum;
        }

        return b;
    }
}