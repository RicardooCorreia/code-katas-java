package leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LongestSubstringWithoutRepeatingCharactersTest {

    private static final LongestSubstringWithoutRepeatingCharacters.Solution subject = new LongestSubstringWithoutRepeatingCharacters.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.of("abcabcbb", 3),
                Arguments.of("bbbbbbbb", 1),
                Arguments.of("pwwkew", 3),
                Arguments.of("a", 1)
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void lengthOfLongestSubstring_examples(
            // Given
            String input,
            int expected) {

        // When
        int result = subject.lengthOfLongestSubstring(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }

    @Test
    void lengthOfLongestSubstring_whenNull_return0() {

        // Given
        String input = null;

        // When
        int result = subject.lengthOfLongestSubstring(input);

        // Then
        assertThat(result)
                .isEqualTo(0);
    }

    @Test
    void lengthOfLongestSubstring_whenEmpty_return0() {

        // Given
        String input = "";

        // When
        int result = subject.lengthOfLongestSubstring(input);

        // Then
        assertThat(result)
                .isEqualTo(0);
    }

    @Test
    void lengthOfLongestSubstring_whenVeryLongString_returnCorrectResult() {

        // Given
        String input = "asfkhgfkjdshfjkhdskjchbsdkfhsdkjfhdskjfhdskjfbkdsfbkjdsbfkjsdbfkjsdhnfkjsdhfksdhfdskjfhsdkfjh" +
                "sdfkjdshkfhjsdhfksdjhfkjdshfksjdbckjsbdjhbfkjsdbkjfbjksdbfkjbdsjkfbjkdsbfbkjsdbfkjdsbfkjdsbfkjsbdckj" +
                "sdfkjdshkfhjsdhfksdjhfkjdshfksjdbckjsbdjhbfkjsdbkjfbjksdbfkjbdsjkfbjkdsbfbkjsdbfkjdsbfkjdsbfkjsbdckj" +
                "sdfkjdshkfhjsdhfksdjhfkjdshfksjdbckjsbdjhbfkjsdbkjfbjksdbfkjbdsjkfbjkdsbfbkjsdbfkjdsbfkjdsbfkjsbdckj" +
                "sdfkjdshkfhjsdhfksdjhfkjdshfksjdbckjsbdjhbfkjsdbkjfbjksdbfkjbdsjkfbjkdsbfbkjsdbfkjdsbfkjdsbfkjsbdckj" +
                "sdfkjdshkfhjsdhfksdjhfkjdshfksjdbckjsbdjhbfkjsdbkjfbjksdbfkjbdsjkfbjkdsbfbkjsdbfkjdsbfkjdsbfkjsbdckj" +
                "fdsljhfdskjhfkjsdhfkdsfjhdskjfhdskkjdsbsdkjfcnbdskjbfkjdsbfdskjfbkdsjbckjsdbckjdsbfkjdsbcjkbkjsdnbck" +
                "fdsljhfdskjhfkjsdhfkdsfjhdskjfhdskkjdsbsdkjfcnbdskjbfkjdsbfdskjfbkdsjbckjsdbckjdsbfkjdsbcjkbkjsdnbck" +
                "fdsljhfdskjhfkjsdhfkdsfjhdskjfhdskkjdsbsdkjfcnbdskjbfkjdsbfdskjfbkdsjbckjsdbckjdsbfkjdsbcjkbkjsdnbck" +
                "fdsljhfdskjhfkjsdhfkdsfjhdskjfhdskkjdsbsdkjfcnbdskjbfkjdsbfdskjfbkdsjbckjsdbckjdsbfkjdsbcjkbkjsdnbck" +
                "fdsljhfdskjhfkjsdhfkdsfjhdskjfhdskkjdsbsdkjfcnbdskjbfkjdsbfdskjfbkdsjbckjsdbckjdsbfkjdsbcjkbkjsdnbck" +
                "fdsljhfdskjhfkjsdhfkdsfjhdskjfhdskkjdsbsdkjfcnbdskjbfkjdsbfdskjfbkdsjbckjsdbckjdsbfkjdsbcjkbkjsdnbck" +
                "fdsljhfdskjhfkjsdhfkdsfjhdskjfhdskkjdsbsdkjfcnbdskjbfkjdsbfdskjfbkdsjbckjsdbckjdsbfkjdsbcjkbkjsdnbck" +
                "fdsljhfdskjhfkjsdhfkdsfjhdskjfhdskkjdsbsdkjfcnbdskjbfkjdsbfdskjfbkdsjbckjsdbckjdsbfkjdsbcjkbkjsdnbck" +
                "dksajhdksahdkjashdkjsahdjhsahkjhfkjdshghkjdshgkjsdhgkjsdhfkjhdskjfhijdsghfghkasdhsakjhdkasghdkjasghd" +
                "dksajhdksahdkjashdkjsahdjhsahkjhfkjdshghkjdshgkjsdhgkjsdhfkjhdskjfhijdsghfghkasdhsakjhdkasghdkjasghd" +
                "dksajhdksahdkjashdkjsahdjhsahkjhfkjdshghkjdshgkjsdhgkjsdhfkjhdskjfhijdsghfghkasdhsakjhdkasghdkjasghd" +
                "dksajhdksahdkjashdkjsahdjhsahkjhfkjdshghkjdshgkjsdhgkjsdhfkjhdskjfhijdsghfghkasdhsakjhdkasghdkjasghd" +
                "dksajhdksahdkjashdkjsahdjhsahkjhfkjdshghkjdshgkjsdhgkjsdhfkjhdskjfhijdsghfghkasdhsakjhdkasghdkjasghd" +
                "dksajhdksahdkjashdkjsahdjhsahkjhfkjdshghkjdshgkjsdhgkjsdhfkjhdskjfhijdsghfghkasdhsakjhdkasghdkjasghd" +
                "dksajhdksahdkjashdkjsahdjhsahkjhfkjdshghkjdshgkjsdhgkjsdhfkjhdskjfhijdsghfghkasdhsakjhdkasghdkjasghd" +
                "dksajhdksahdkjashdkjsahdjhsahkjhfkjdshghkjdshgkjsdhgkjsdhfkjhdskjfhijdsghfghkasdhsakjhdkasghdkjasghd" +
                "dksajhdksahdkjashdkjsahdjhsahkjhfkjdshghkjdshgkjsdhgkjsdhfkjhdskjfhijdsghfghkasdhsakjhdkasghdkjasghd" +
                "kghkjsahdkjashdkjashdkjhaskdhjashdjkhasjkdhjkashjkdhjksahdjkhjaksfhiusdglgfheiarhflbcljbldsbfulyyhwe" +
                "ghjdsbfkjhsddklfhnkldshfhkjdshfkjsdhbgjhgbfdkujnhgiolfdnvkjfdnbvivudfiguhbdfkjgbkdjfbgnkdjfbgkjdfnkj" +
                "ghjdsbfkjhsddklfhnkldshfhkjdshfkjsdhbgjhgbfdkujnhgiolfdnvkjfdnbvivudfiguhbdfkjgbkdjfbgnkdjfbgkjdfnkj" +
                "ghjdsbfkjhsddklfhnkldshfhkjdshfkjsdhbgjhgbfdkujnhgiolfdnvkjfdnbvivudfiguhbdfkjgbkdjfbgnkdjfbgkjdfnkj" +
                "ghjdsbfkjhsddklfhnkldshfhkjdshfkjsdhbgjhgbfdkujnhgiolfdnvkjfdnbvivudfiguhbdfkjgbkdjfbgnkdjfbgkjdfnkj" +
                "ghjdsbfkjhsddklfhnkldshfhkjdshfkjsdhbgjhgbfdkujnhgiolfdnvkjfdnbvivudfiguhbdfkjgbkdjfbgnkdjfbgkjdfnkj" +
                "nfkdsjbfkdsfjskjdbfkjdshflkdsnfkljnsdjkgbndaçoghaçuichgmlaskdhfnvckluhnagcljksdghfklcjgdashlkjfskldd" +
                "nfkdsjbfkdsfjskjdbfkjdshflkdsnfkljnsdjkgbndaçoghaçuichgmlaskdhfnvckluhnagcljksdghfklcjgdashlkjfskldd" +
                "nfkdsjbfkdsfjskjdbfkjdshflkdsnfkljnsdjkgbndaçoghaçuichgmlaskdhfnvckluhnagcljksdghfklcjgdashlkjfskldd" +
                "nfkdsjbfkdsfjskjdbfkjdshflkdsnfkljnsdjkgbndaçoghaçuichgmlaskdhfnvckluhnagcljksdghfklcjgdashlkjfskldd" +
                "fsldjhfkjsdffjhgfkjnasdkjdflkxjshfgklsdahglkasgkfjghsdçajfhsdkjnckjsdbckjsdbkjbdfkjbsdkjgfhkusdhhfls";

        // When
        int result = subject.lengthOfLongestSubstring(input);

        // Then
        assertThat(result)
                .isEqualTo(12);
    }
}