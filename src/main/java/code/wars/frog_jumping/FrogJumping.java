package code.wars.frog_jumping;

import java.util.ArrayList;
import java.util.List;

public class FrogJumping {

    public static int solution(int[] a) {

        int currentIndex = 0, jumpCount = 0;
        List<Integer> previousPositions = new ArrayList<>();
        while (currentIndex < a.length && currentIndex >= 0) {

            if(previousPositions.contains(currentIndex)) {
                return -1;
            }
            int jumpLength = a[currentIndex];
            previousPositions.add(currentIndex);
            currentIndex+=jumpLength;
            jumpCount++;
        }
        return jumpCount;
    }
}
