package code.wars.remove_first_and_last_character;

public class RemoveChars {

    public static String remove(String str) {

        if (str != null && str.length() > 2) {
            return str.substring(1, str.length() - 1);
        }
        return "";
    }
}
