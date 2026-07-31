package code.wars.filter_the_number;

public class Kata {

    public static long filterString(final String value) {

        final var stringBuilder = new StringBuilder();
        value.chars()
            .filter(Character::isDigit)
            .mapToObj(i -> i - '0')
            .forEach(stringBuilder::append);

        if (stringBuilder.isEmpty()) return 0;

        return Long.parseLong(stringBuilder.toString());
    }
}