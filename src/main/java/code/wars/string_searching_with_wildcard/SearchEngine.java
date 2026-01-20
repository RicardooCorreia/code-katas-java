package code.wars.string_searching_with_wildcard;

public class SearchEngine {
    static int find(String needle, String haystack) {

        char[] chars = haystack.toCharArray();
        char[] needleChars = needle.toCharArray();
        for (int i = 0; i < chars.length - needleChars.length; i++) {
            if (chars[i] == needleChars[0] || needleChars[0] == '_') {
                boolean found = true;
                for (int j = 1; j < needleChars.length; j++) {
                    if (chars[i + j] != needleChars[j] && needleChars[j] != '_') {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    return i;
                }
            }
        }

        return -1;
    }
}

