package code.wars.all_inclusive;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Rotations {

    public static boolean containAllRots(String string, List<String> rotations) {

        if (string.isBlank()) {
            return true;
        }

        final Set<String> possibleRotations = new HashSet<>();
        String currentRotation = string;
        do {

            final String lastChar = currentRotation.substring(currentRotation.length() - 1);
            currentRotation = lastChar + currentRotation.substring(0, currentRotation.length() - 1);
            possibleRotations.add(currentRotation);

        } while (!string.equals(currentRotation));

        return rotations.containsAll(possibleRotations);
    }
}
