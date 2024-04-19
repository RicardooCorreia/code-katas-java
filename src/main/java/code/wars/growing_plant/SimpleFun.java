package code.wars.growing_plant;

public class SimpleFun {

    public static int growingPlant(int upSpeed, int downSpeed, int desiredHeight) {

        int currentHeight = 0;
        int days = 1;
        while (currentHeight + upSpeed < desiredHeight) {
            currentHeight += upSpeed - downSpeed;
            days++;
        }
        return days;
    }
}
