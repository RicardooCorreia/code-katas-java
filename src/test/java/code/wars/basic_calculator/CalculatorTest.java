package code.wars.basic_calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorTest {

    @Nested
    class ValidOperationsTests {

        @ParameterizedTest
        @CsvSource({
            "3.2, 8, 11.2",
            "-3, 0, -3.0"
        })
        void should_returnSum_when_adding(double a, double b, double expected) {
            // given
            String operator = "+";

            // when
            Double result = Calculator.calculate(a, operator, b);

            // then
            assertThat(result).isCloseTo(expected, within(1e-6));
        }

        @ParameterizedTest
        @CsvSource({
            "3.2, 8, -4.8",
            "-3, 0, -3.0"
        })
        void should_returnDifference_when_subtracting(double a, double b, double expected) {
            // given
            String operator = "-";

            // when
            Double result = Calculator.calculate(a, operator, b);

            // then
            assertThat(result).isCloseTo(expected, within(1e-6));
        }

        @ParameterizedTest
        @CsvSource({
            "3.2, 8, 0.4",
            "-2, -2, 1.0"
        })
        void should_returnQuotient_when_dividing(double a, double b, double expected) {
            // given
            String operator = "/";

            // when
            Double result = Calculator.calculate(a, operator, b);

            // then
            assertThat(result).isCloseTo(expected, within(1e-6));
        }

        @ParameterizedTest
        @CsvSource({
            "3.2, 8, 25.6",
            "-3, 0, 0.0"
        })
        void should_returnProduct_when_multiplying(double a, double b, double expected) {
            // given
            String operator = "*";

            // when
            Double result = Calculator.calculate(a, operator, b);

            // then
            assertThat(result).isCloseTo(expected, within(1e-6));
        }
    }

    @Nested
    class NullResultTests {

        @Test
        void should_returnNull_when_dividingByZero() {
            // given
            double a = -3;
            String operator = "/";
            double b = 0;

            // when
            Double result = Calculator.calculate(a, operator, b);

            // then
            assertThat(result).isNull();
        }

        @Test
        void should_returnNull_when_operatorIsInvalid() {
            // given
            double a = -3;
            String operator = "w";
            double b = 0;

            // when
            Double result = Calculator.calculate(a, operator, b);

            // then
            assertThat(result).isNull();
        }
    }
}