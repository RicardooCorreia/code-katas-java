package code.wars.adding_big_numbers;

public class Kata {

    public static String add(String a, String b) {

        final String number1 = new StringBuilder(a).reverse().toString();
        final String number2 = new StringBuilder(b).reverse().toString();
        final StringBuilder result = new StringBuilder();

        int remaining = 0;
        int i = 0;

        final int number1Length = number1.length();
        final int number2Length = number2.length();
        final int minLength = number1Length > number2Length ? number2Length : number1Length;

        while (i < minLength) {

            final int n1 = getNumber(number1, i);
            final int n2 = getNumber(number2, i);

            final int addResult = n1 + n2 + remaining;
            remaining = addResult / 10;
            result.append(addResult % 10);
            i++;
        }

        addRestOfBiggerNumberPlusRemaining(a, b, result, remaining, i, number1Length, number2Length, minLength);

        return removeExtraZeros(result);
    }

    private static String removeExtraZeros(StringBuilder result) {

        final String string = result.reverse().toString();
        return string.replaceFirst("^0+(?!$)", "");
    }

    private static void addRestOfBiggerNumberPlusRemaining(String a,
                                                           String b,
                                                           StringBuilder result,
                                                           int remaining,
                                                           int i,
                                                           int number1Length,
                                                           int number2Length,
                                                           int minLength) {

        if (number1Length != number2Length) {
            addRemainingNumbers(a, b, result, remaining, i, number1Length, number2Length, minLength);
        } else if (remaining > 0){
            result.append(remaining);
        }
    }

    private static void addRemainingNumbers(String a,
                                            String b,
                                            StringBuilder result,
                                            int remaining,
                                            int i,
                                            int number1Length,
                                            int number2Length,
                                            int minLength) {

        if (number1Length == minLength) {
            addRemainingNumbers(b, result, remaining, i, number2Length);
        } else {
            addRemainingNumbers(a, result, remaining, i, number1Length);
        }
    }

    private static void addRemainingNumbers(String number,
                                            StringBuilder result,
                                            int remaining,
                                            int iteration,
                                            int numberLength) {

        final String substring = number.substring(0, numberLength - iteration);
        final String missing = add(substring, String.valueOf(remaining));
        result.append(new StringBuilder(missing).reverse());
    }

    private static int getNumber(String number1, int i) {
        return number1.charAt(i) - 48;
    }
}
