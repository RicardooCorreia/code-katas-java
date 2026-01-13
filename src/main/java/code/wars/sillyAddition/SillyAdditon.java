package code.wars.sillyAddition;

public class SillyAdditon {

    public static int add(int num1, int num2) {

        String first = String.valueOf(num1);
        String second = String.valueOf(num2);

        StringBuilder result = new StringBuilder();

        int maxLength = Math.max(first.length(), second.length());
        for (int i = 0; i < maxLength; i++) {
            int firstNumber = getNumericNumber(first, maxLength, i);
            int secondNumber = getNumericNumber(second, maxLength, i);
            result.insert(0, firstNumber + secondNumber);
        }

        return Integer.parseInt(result.toString());
    }

    private static int getNumericNumber(String number, int maxLength, int i) {
        if (number.length() > i) {
            char c = number.charAt(number.length() - i - 1);
            return Character.getNumericValue(c);
        } else {
            return 0;
        }
    }
}
