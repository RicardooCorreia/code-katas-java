package code.wars.stop_gninnips_my_sdrow;

public class SpinWords {

    public static final int MINIMUM_WORD_LENGTH = 5;

    public static final String SPACE = " ";

    public String spinWords(String sentence) {

        final StringBuilder builder = new StringBuilder();
        final String[] words = sentence.split(SPACE);
        for (String word : words) {
            builder
                    .append(word.length() >= MINIMUM_WORD_LENGTH ? reverseWord(word) : word)
                    .append(SPACE);
        }
        deleteLastSpace(builder);
        return builder.toString();
    }

    private void deleteLastSpace(StringBuilder builder) {

        builder.deleteCharAt(builder.lastIndexOf(SPACE));
    }

    private String reverseWord(String word) {

        return new StringBuilder(word).reverse().toString();
    }
}
