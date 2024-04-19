package haker.rank.cut_the_sticks;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'cutTheSticks' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> cutTheSticks(List<Integer> sticks) {
        // Write your code here

        return countSticks(sticks, new ArrayList<>());
    }

    private static List<Integer> countSticks(List<Integer> sticks, List<Integer> count) {

        if (sticks.size() == 0) {
            return count;
        }

        count.add(sticks.size());

        return countSticks(breakSticks(sticks), count);
    }

    private static List<Integer> breakSticks(List<Integer> sticks) {

        final int min = sticks.stream()
                .mapToInt(value -> value)
                .min()
                .orElseThrow(RuntimeException::new);

        return sticks.stream()
                .map(value -> value - min)
                .filter(value -> value > 0)
                .toList();
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.cutTheSticks(arr);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

