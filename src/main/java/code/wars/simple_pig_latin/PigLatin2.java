package code.wars.simple_pig_latin;

public class PigLatin2 {

    public static String pigIt(String phrase) {

        return phrase.replaceAll("(\\w)(\\w*)", "$2$1ay");
    }
}
