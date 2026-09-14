package code.wars.ordering_the_words;

import static java.util.stream.Collectors.joining;

public class Ordering {

    public String orderWord(String s) {

        if (s == null || s.isBlank()) {
            return "Invalid String!";
        }

        return s.chars()
            .sorted()
            .boxed()
            .map(Character::toString)
            .collect(joining());
    }
}
