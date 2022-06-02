package code.wars.string_merge;

public class Kata {

    public static String stringMerge(String s1, String s2, char letter) {

        final int index1 = s1.indexOf(letter);
        final int index2 = s2.indexOf(letter);

        final String firstHalf = s1.substring(0, index1);
        final String secondHalf = s2.substring(index2);
        return firstHalf + secondHalf;
    }
}
