package code.wars.driving_circles;

public class Main {

    public static int tour(int[] petrol, int[] distance) {

        for (int start = 0; start < petrol.length; start++) {

            int currentPetrol = 0;
            int petrolStations = 0;
            for (int i = 0; i < petrol.length; i++) {

                int trueIndex = (start + i) % petrol.length;
                currentPetrol += petrol[trueIndex] - distance[trueIndex];
                petrolStations++;

                if (currentPetrol < 0) {
                    break;
                }
            }

            if (petrolStations == petrol.length) {
                return start;
            }
        }
        return -1;
    }
}
