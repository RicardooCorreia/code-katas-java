package code.wars.common_substrings;

import static java.util.Locale.ROOT;

class Kata {

    public static boolean SubstringTest(String str1, String str2) {
        final String longest = str1.toLowerCase(ROOT);
        final String shortest = str2.toLowerCase(ROOT);

        final char[] charArray = shortest.toCharArray();
        for (int i = 0; i < charArray.length - 1; i++) {
            String search = "" + charArray[i] + charArray[i + 1];
            if (longest.contains(search)) {
                return true;
            }
        }
        return false;
    }
}
