package code.wars.get_the_middle_character;

class Kata {
    public static String getMiddle(String word) {

        final int length = word.length();
        final char[] chars = word.toCharArray();
        final int halfSize = length / 2;
        if (length % 2 == 0) {
            return chars[halfSize - 1] + "" + chars[halfSize];
        } else {
            return "" + chars[halfSize];
        }
    }
}
