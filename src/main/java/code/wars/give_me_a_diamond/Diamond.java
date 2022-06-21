package code.wars.give_me_a_diamond;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Diamond {
    public static String print(int n) {

        if (n < 1 || n % 2 == 0) return null;

        final List<String> lines = new ArrayList<>();
        int nSpaces = n / 2;
        for (int i = 0; i < n / 2; i++) {

            String line =
                    fill(nSpaces, " ") + fill(n - (nSpaces * 2), "*");
            lines.add(line);
            nSpaces--;
        }

        lines.add(fill(n, "*"));

        for (int i = n / 2 - 1; i >= 0; i--) {
            lines.add(lines.get(i));
        }
        return String.join("\n", lines) + "\n";
    }

    private static String fill(int amount, String filling) {
        return IntStream.range(0, amount)
                .mapToObj(value -> filling)
                .collect(Collectors.joining());
    }
}
