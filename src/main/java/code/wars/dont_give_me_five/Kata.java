package code.wars.dont_give_me_five;

import java.util.stream.IntStream;

public class Kata {

    public static int dontGiveMeFive(int start, int end) {

        return (int) IntStream.rangeClosed(start, end)
                .filter(value -> !String.valueOf(value).contains("5"))
                .count();
    }
}
