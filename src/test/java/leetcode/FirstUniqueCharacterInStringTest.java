package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class FirstUniqueCharacterInStringTest {

    private final FirstUniqueCharacterInString.Solution subject = new FirstUniqueCharacterInString.Solution();

    @ParameterizedTest
    @CsvSource({
            "leetcode,0",
            "loveleetcode,2",
            "aabb, -1"
    })
    void firstUniqChar(
            // Given
            String input,
            int expected) {

        // When
        int result = subject.firstUniqChar(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}