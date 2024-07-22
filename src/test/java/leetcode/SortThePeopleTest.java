package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SortThePeopleTest {

    private final SortThePeople.Solution subject = new SortThePeople.Solution();

    public static Stream<Arguments> example() {

        return Stream.of(
                arguments(new String[]{"Mary", "John", "Emma"}, new int[]{180, 165, 170}, new String[]{"Mary", "Emma", "John"}),
                arguments(new String[]{"Alice", "Bob", "Bob"}, new int[]{155, 185, 150}, new String[]{"Bob", "Alice", "Bob"})
        );
    }

    @ParameterizedTest
    @MethodSource("example")
    void sortPeople(
            // Given
            String[] names,
            int[] heights,
            String[] expected) {

        // When
        String[] result = subject.sortPeople(names, heights);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}