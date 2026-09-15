package code.wars.sum_of_numbers_from_zero_to_n;

public class SequenceSum {

    public static String showSequence(int value) {

        if (value == 0) {
            return "0=0";
        } else if (value < 0) {
            return value + "<0";
        }

        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for (var i = 0; i <= value; i++) {
            sb
                .append(i)
                .append("+");
            sum += i;
        }

        sb.deleteCharAt(sb.length() - 1);
        sb.append(" = ").append(sum);

        return sb.toString();
    }
}
