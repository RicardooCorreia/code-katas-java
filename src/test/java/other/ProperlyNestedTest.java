package other;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class ProperlyNestedTest {

    private final ProperlyNested subject = new ProperlyNested();

    @ParameterizedTest
    @ValueSource(strings = {"([{}])", "(){}[]", "({}[])"})
    void isCorrectlyNested_validScenarios(
            // Given
            String input) {

        // When
        boolean result = subject.isCorrectlyNested(input);

        // Then
        assertThat(result)
                .isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"([{", "([{))", "([){}]"})
    void isCorrectlyNested_invalidScenarios(
            // Given
            String input) {

        // When
        boolean result = subject.isCorrectlyNested(input);

        // Then
        assertThat(result)
                .isFalse();
    }
}
