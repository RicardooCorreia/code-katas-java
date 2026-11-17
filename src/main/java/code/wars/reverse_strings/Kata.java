package code.wars.reverse_strings;

public class Kata {

    public static String solution(String str) {

        StringBuilder sb = new StringBuilder();
        for (int i = str.toCharArray().length - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}
