package code.wars.find_your_villain_name;

import java.time.LocalDate;

public class Kata {

    private static final String[] FIRST = {
        "The Evil",
        "The Vile",
        "The Cruel",
        "The Trashy",
        "The Despicable",
        "The Embarrassing",
        "The Disreputable",
        "The Atrocious",
        "The Twirling",
        "The Orange",
        "The Terrifying",
        "The Awkward"
    };
    private static final String[] LAST = {
        "Mustache",
        "Pickle",
        "Hood Ornament",
        "Raisin",
        "Recycling Bin",
        "Potato",
        "Tomato",
        "House Cat",
        "Teaspoon",
        "Laundry Basket"
    };

    public static String getVillianName(LocalDate birthdate) {

        final var month = birthdate.getMonth().getValue() - 1;
        final var dayOfMonth = String.valueOf(birthdate.getDayOfMonth());
        final var lastIndex = dayOfMonth.charAt(dayOfMonth.length() - 1) - '0';
        return FIRST[month] + " " + LAST[lastIndex];
    }
}
