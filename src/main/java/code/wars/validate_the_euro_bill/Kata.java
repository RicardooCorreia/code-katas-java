package code.wars.validate_the_euro_bill;

public class Kata {
    public static boolean validateEuro(String serialNumber) {
        int sum = 0;
        final var charArray = serialNumber.toCharArray();
        for (var i = 0; i < 2; i++) {
            sum += charArray[i] - 'A' + 1;
        }

        for (int i = 2; i < charArray.length; i++) {
            sum += charArray[i] - '0';
        }

        while (sum >= 10) {
            int result = 0;
            for (var part : String.valueOf(sum).split("")) {
                result += Integer.parseInt(part);
            }
            sum = result;
        }

        return sum == 7;
    }
}
