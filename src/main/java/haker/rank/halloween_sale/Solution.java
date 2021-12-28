package haker.rank.halloween_sale;

import java.io.*;

class Result {

    public static int howManyGames(int baseGamePrice, int discount, int minimumPrice, int wallet) {

        return howManyGames(baseGamePrice, discount, minimumPrice, wallet, 0);
    }

    private static int howManyGames(int gamePrice, int discount, int minimumPrice, int wallet, int gameCount) {

        if (gamePrice > wallet) {
            return gameCount;
        }
        final int nextGamePrice = Math.max(gamePrice - discount, minimumPrice);
        return howManyGames(nextGamePrice, discount, minimumPrice, wallet - gamePrice, gameCount + 1);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int p = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        int m = Integer.parseInt(firstMultipleInput[2]);

        int s = Integer.parseInt(firstMultipleInput[3]);

        int answer = Result.howManyGames(p, d, m, s);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
