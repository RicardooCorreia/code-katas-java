package code.wars.simple_prime_streaming;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SimplePrimeStreaming {

    public static String solve(int a, int b) {

        AtomicInteger integer = new AtomicInteger(2);
        return IntStream.generate(integer::getAndIncrement)
                .filter(SimplePrimeStreaming::isPrime)
                .mapToObj(String::valueOf)
                .flatMap(string -> Arrays.stream(string.split("")))
                .skip(a)
                .limit(b)
                .collect(Collectors.joining());
    }

    private static boolean isPrime(int number) {

        if (number == 2) {
            return true;
        }
        if (number % 2 == 0) {
            return false;
        }

        int sqrt = (int) Math.sqrt(number);
        for (int i = 3; i <= sqrt; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
