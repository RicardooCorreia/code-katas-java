package code.wars.consecutive_strings;

class LongestConsec {

    public static String longestConsec(String[] words, int k) {

        final int wordsLength = words.length;
        if (k <= 0 || k > wordsLength) {
            return "";
        }
        if (k == wordsLength) {
            return String.join("", words);
        }

        String longestWord = "";
        for (int i = 0; i + k <= wordsLength; i++) {
            String conesecutiveWord = constructWord(i, k, words);
            if (conesecutiveWord.length() > longestWord.length()) {
                longestWord = conesecutiveWord;
            }
        }
        return longestWord;
    }

    private static String constructWord(int i, int k, String[] words) {

        final StringBuilder stringBuilder = new StringBuilder();
        for (int j = i; j < i + k; j++) {
            stringBuilder.append(words[j]);
        }
        return stringBuilder.toString();
    }
}
