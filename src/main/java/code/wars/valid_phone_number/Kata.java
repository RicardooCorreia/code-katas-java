package code.wars.valid_phone_number;

public class Kata {

    public static boolean validPhoneNumber(String phoneNumber) {

        return phoneNumber.matches("^\\(\\d{3}\\) \\d{3}-\\d{4}$");
    }
}
