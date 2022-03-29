package code.wars.bouncing_balls;

public class BouncingBall {

    public static int bouncingBall(double floorNumber, double bounce, double window) {

        if (floorNumber <= 0 || bounce <= 0 || bounce >= 1 || window >= floorNumber) {
            return -1;
        }

        // Ball failing down
        int viewCount = 1;
        double currentHeight = floorNumber;
        while (currentHeight > window) {
            viewCount+=2;
            currentHeight = currentHeight * bounce;
        }

        return viewCount - 2;
    }
}
