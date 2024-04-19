package code.wars.return_1_2_3_random;

import java.util.Random;

public class Main {

    private static int oneTwo() {

        final Random random = new Random();
        return random.nextInt(3 - 1) + 1;
    }

    public static int oneTwoThree() {

        if (oneTwo() == 1)
            return oneTwo();
        else
            return oneTwo() == 1 ? 3 : oneTwoThree();
    }
}
