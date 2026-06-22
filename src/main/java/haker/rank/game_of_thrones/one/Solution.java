package haker.rank.game_of_thrones.one;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

class Result {

    /*
     * Complete the 'gameOfThrones' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String gameOfThrones(String s) {

        final var letterCount = s.chars()
            .boxed()
            .collect(groupingBy(identity(), counting()));

        final var isEvenLength = s.length() % 2 == 0;
        if (isEvenLength) {
            return letterCount.values().stream()
                       .allMatch(aLong -> aLong % 2 == 0) ? "YES" : "NO";
        } else {
            final var hasOneOdd = allButOneIsEven(letterCount);
            return hasOneOdd ? "YES" : "NO";
        }
    }

    private static Boolean allButOneIsEven(Map<Integer, Long> letterCount) {
        var oddFound = false;
        for (var count : letterCount.values()) {
            if (count % 2 != 0) {
                if (!oddFound) {
                    oddFound = true;
                } else {
                    return false;
                }
            }
        }
        return oddFound;
    }

}

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.gameOfThrones(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
