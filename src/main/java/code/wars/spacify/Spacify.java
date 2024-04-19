package code.wars.spacify;

public class Spacify {

    public static String spacify(String str) {

        final StringBuilder stringBuilder = new StringBuilder();
        for (char c : str.toCharArray()) {

            stringBuilder
                    .append(c)
                    .append(" ");
        }

        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }
}
