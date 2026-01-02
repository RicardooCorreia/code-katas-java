package code.wars.is_the_string_uppercase;

public class Kata {
    public static boolean isUpperCase(String s) {

        return s.chars()
                .filter(Character::isLetter)
                .allMatch(Character::isUpperCase);
    }
}
