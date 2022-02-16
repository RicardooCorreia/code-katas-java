package code.wars.detect_pangram;

public class PangramChecker2 {

    public boolean check(String sentence) {

        return sentence.chars()
                .map(Character::toLowerCase)
                .filter(Character::isAlphabetic)
                .distinct()
                .count() == 26;
    }
}
