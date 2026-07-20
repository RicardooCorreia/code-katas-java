package code.wars.sort_the_gift_code;

import static java.util.stream.Collectors.joining;

public class GiftSorter {

    public String sortGiftCode(String code) {

        return code.chars()
            .sorted()
            .boxed()
            .map(integer -> Character.toString((char) integer.intValue()))
            .collect(joining());
    }
}
