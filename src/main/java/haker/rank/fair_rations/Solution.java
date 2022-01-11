package haker.rank.fair_rations;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    public static String fairRations(List<Integer> people) {

        // Validate if sum is even
        final int sum = people.stream()
                .mapToInt(value -> value)
                .sum();

        if (isOdd(sum)) {
            return "NO";
        }

        return calculateLoafs(people);
    }

    private static String calculateLoafs(List<Integer> people) {

        final ArrayList<Integer> peopleArrayList = new ArrayList<>(people);
        int loafCount = 0;

        for (int i = 0; i < peopleArrayList.size(); i++) {

            final Integer nLoafs = peopleArrayList.get(i);
            if (isOdd(nLoafs)) {
                peopleArrayList.set(i, nLoafs + 1);
                peopleArrayList.set(i + 1, peopleArrayList.get(i + 1) + 1);
                loafCount+=2;
            }
        }

        return String.valueOf(loafCount);
    }

    private static boolean isOdd(Integer nLoafs) {

        return nLoafs % 2 != 0;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int N = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> B = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        String result = Result.fairRations(B);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

