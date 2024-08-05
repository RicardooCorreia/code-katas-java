package leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CountItemsMatchingRuleTest {

    private final CountItemsMatchingRule.Solution subject = new CountItemsMatchingRule.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments(new String[][]{{"phone","blue","pixel"},{"computer","silver","lenovo"},{"phone","gold","iphone"}}, "color", "silver", 1),
                Arguments.arguments(new String[][]{{"phone","blue","pixel"},{"computer","silver","phone"},{"phone","gold","iphone"}}, "type", "phone", 2)
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void countMatches(
            // Given
            String[][] items,
            String ruleKey,
            String ruleValue,
            int expected) {

        List<List<String>> input = Arrays.stream(items)
                .map(item -> List.of(item[0], item[1], item[2]))
                .toList();

        // When
        int result = subject.countMatches(input, ruleKey, ruleValue);

        // Then
        assertEquals(expected, result);
    }
}