package code.wars.multiples_of_3_and_5;

import java.util.stream.IntStream;

public class Solution {

    public int solution(int number) {

        if (number < 3) {
            return 0;
        }

        return IntStream.range(2, number)
                .filter(n -> n % 3 == 0 || n % 5 == 0)
                .sum();
    }
}
