package code.wars.sentence_smash;

public class SmashWords {

    public static String smash(String... words) {

        return String.join(" ", words).trim();
    }
}
