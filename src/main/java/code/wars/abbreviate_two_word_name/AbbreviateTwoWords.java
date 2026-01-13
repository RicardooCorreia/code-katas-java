package code.wars.abbreviate_two_word_name;

public class AbbreviateTwoWords {

    public static String abbrevName(String name) {

        String[] parts = name.split(" ");
        return Character.toUpperCase(parts[0].charAt(0)) + "." +
                Character.toUpperCase(parts[1].charAt(0));
    }
}
