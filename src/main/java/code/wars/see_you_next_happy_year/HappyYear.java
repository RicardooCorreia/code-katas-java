package code.wars.see_you_next_happy_year;

public class HappyYear {

    public static int nextHappyYear(int year) {

        int nextYear = year + 1;
        while (!isHappy(nextYear)) {
            nextYear++; // This can optimize by skipping years. Example: 7701 can skip all the way to 7801
        }
        return nextYear;
    }

    private static boolean isHappy(int nextYear) {

        final String yearString = String.valueOf(nextYear);
        return yearString.chars()
                .distinct()
                .count() == yearString.length();
    }
}
