package code.wars.help_bob_count_letters_and_digits;

public class Kata {

    public static int countLettersAndDigits(String input) {

        return Math.toIntExact(input.chars()
            .filter(Character::isLetterOrDigit)
            .count());
    }
}