package haker.rank.viral_advertising;

import java.io.*;

class Result {

    public static int viralAdvertising(int n) {


        if (n == 0) {
            return 0;
        }

        final int initialShares = 5;

        return advertise(initialShares, 0, n);
    }

    public static int advertise(final int previousDayShared, final int accumulatedLikes, final int daysRemaining) {

        final int liked = previousDayShared / 2;
        final int sharesOfTheDay = liked * 3;
        return daysRemaining <= 0 ?
                accumulatedLikes :
                advertise(sharesOfTheDay, accumulatedLikes + liked, daysRemaining - 1);
    }
}


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.viralAdvertising(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

