package code.wars.build_tower;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Kata {

    public static String[] towerBuilder(int nFloors) {

        if (nFloors <= 0) {
            return new String[0];
        } else if (nFloors == 1) {
            return new String[]{"*"};
        }

        int width = getStarsCount(nFloors);
        final List<String> tower = new ArrayList<>();

        for (int i = 0; i < nFloors; i++) {
            final int starsCount = getStarsCount(i + 1);
            int spacesCount = width - starsCount;
            int spacesPerSide = spacesCount / 2;
            final String spaces = generate(spacesPerSide, " ");
            final String stars = generate(starsCount, "*");
            tower.add(spaces + stars + spaces);
        }
        return tower.toArray(new String[0]);
    }

    private static String generate(int spacesPerSide, String element) {

        return Stream.generate(() -> element)
                .limit(spacesPerSide)
                .collect(Collectors.joining());
    }

    private static int getStarsCount(int number) {

        return Math.max(1, number * 2 - 1);
    }
}
