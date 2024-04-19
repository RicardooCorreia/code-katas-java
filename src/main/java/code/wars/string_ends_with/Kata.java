package code.wars.string_ends_with;

public class Kata {

    public static boolean solution(String str, String ending) {

        if (ending.length() > str.length()) {
            return false;
        }

        String substring = str.substring(str.length() - ending.length());
        return substring.equals(ending);
    }
}
