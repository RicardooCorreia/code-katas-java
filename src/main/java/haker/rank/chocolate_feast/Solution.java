package haker.rank.chocolate_feast;

import java.io.*;
import java.util.stream.IntStream;

class Result {

    public static int chocolateFeast(int money, int barCost, int wrappersConversion) {

        final int barsBought = money / barCost;

        return barsBought + exchangeWrappers(barsBought, wrappersConversion, 0);
    }

    private static int exchangeWrappers(int wrappers, int wrappersConversion, int chocolateCount) {

        if (wrappers >= wrappersConversion) {
            final int convertedWrappers = wrappers / wrappersConversion;
            final int wrappersRemaining = wrappers % wrappersConversion;
            return exchangeWrappers(
                    convertedWrappers + wrappersRemaining,
                    wrappersConversion,
                    chocolateCount + convertedWrappers);
        } else {
            return chocolateCount;
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int c = Integer.parseInt(firstMultipleInput[1]);

                int m = Integer.parseInt(firstMultipleInput[2]);

                int result = Result.chocolateFeast(n, c, m);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

