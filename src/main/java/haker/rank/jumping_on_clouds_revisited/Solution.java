package haker.rank.jumping_on_clouds_revisited;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    public static final int ORIGINAL_ENERGY = 100;

    static int jumpingOnClouds(int[] clouds, int jumpSize) {

        return jumpOnClouds(clouds, 0, jumpSize, clouds.length, ORIGINAL_ENERGY);
    }

    private static int jumpOnClouds(int[] clouds, int cloudIndex, int jumpSize, int length, int energy) {

        final int newCloudIndex = jump(jumpSize, cloudIndex, length);
        final int energySpent = isCharged(clouds[newCloudIndex]) ? 3 : 1;

        final int currentEnergy = energy - energySpent;
        if (newCloudIndex == 0) {
            return currentEnergy;
        }

        return jumpOnClouds(clouds, newCloudIndex, jumpSize, length, currentEnergy);
    }

    private static boolean isCharged(int clouds) {
        return clouds > 0;
    }

    private static int jump(int jumpSize, int cloudIndex, int length) {

        return (cloudIndex + jumpSize) % length;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

