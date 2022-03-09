package code.wars.count_the_smiley_faces;

import java.util.List;

public class SmileFaces {

    public static int countSmileys(List<String> arr) {

        return Math.toIntExact(arr.stream()
                .filter(SmileFaces::isValidSmile)
                .count());
    }

    public static int countSmileysRegex(List<String> arr) {

        return Math.toIntExact(arr.stream()
                .filter(smile -> smile.matches("[:;][-~]?[)D]"))
                .count());
    }

    private static boolean isValidSmile(String smile) {

        return smile.length() <= 3 &&
                hasEyes(smile) &&
                (doesNotHaveNose(smile) || hasAcceptableNose(smile)) &&
                hasSmilingMouth(smile);
    }

    private static boolean hasEyes(String smile) {

        final char eyes = smile.charAt(0);
        return eyes == ':' || eyes == ';';
    }

    private static boolean hasAcceptableNose(String smile) {

        final char nose = smile.charAt(1);
        return nose == '-' || nose == '~';
    }

    private static boolean hasSmilingMouth(String smile) {

        final char mouth = smile.charAt(smile.length() - 1);
        return mouth == ')' || mouth == 'D';
    }

    private static boolean doesNotHaveNose(String smile) {

        return smile.length() == 2;
    }
}
