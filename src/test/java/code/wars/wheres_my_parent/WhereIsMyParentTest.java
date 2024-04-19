package code.wars.wheres_my_parent;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class WhereIsMyParentTest {

    public static Stream<Arguments> baseTests() {

        return Stream.of(
                arguments("CbcBcbaA", "AaBbbCcc"),
                arguments("AaaaaZazzz", "AaaaaaZzzz"),
                arguments("xXfuUuuF", "FfUuuuXx")
        );
    }

    @ParameterizedTest
    @MethodSource("baseTests")
    void findChildren_whenChildrenAreDispersed_returnSortedString(
            // Given
            String input,
            String expected) {


        // When
        final String result = WhereIsMyParent.findChildren(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }

    @Test
    void findChildren_whenEmpty_returnEmpty() {

        // Given
        final String input = "";

        // When
        final String result = WhereIsMyParent.findChildren(input);

        // Then
        assertThat(result)
                .isEmpty();
    }

    @Test
    void findChildren_whenIsAlreadySorted_returnSameString() {

        // Given
        final String input = "FfUuuuXx";

        // When
        final String result = WhereIsMyParent.findChildren(input);

        // Then
        assertThat(result)
                .isEqualTo(input);
    }
}
