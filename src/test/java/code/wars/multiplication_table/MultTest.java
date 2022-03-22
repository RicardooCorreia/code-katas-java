package code.wars.multiplication_table;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MultTest {

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                arguments(5, 5, "12345\n24680\n36925\n48260\n50505"),
                arguments(7, 15, "123456789012345\n246802468024680\n369258147036925\n482604826048260\n505050505050505\n628406284062840\n741852963074185")
        );
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    public void table_baseTests(
            // Given
            int row,
            int column,
            String expected) {

        // When
        final String result = Mult.table(row, column);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}
