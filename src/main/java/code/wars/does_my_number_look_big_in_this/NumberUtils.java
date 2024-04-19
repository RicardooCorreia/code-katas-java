package code.wars.does_my_number_look_big_in_this;

public class NumberUtils {

    public static boolean isNarcissistic(int number) {

        String numberString = String.valueOf(number);
        return numberString
                .chars()
                .map(operand -> operand - 48)
                .mapToDouble(operand -> Math.pow(operand, numberString.length()))
                .sum() - number == 0;
    }
}
