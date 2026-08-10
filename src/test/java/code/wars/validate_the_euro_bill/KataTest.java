package code.wars.validate_the_euro_bill;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static code.wars.validate_the_euro_bill.Kata.validateEuro;
import static org.assertj.core.api.Assertions.assertThat;

class KataTest {

    @Nested
    class PositiveTests {

        @ParameterizedTest
        @ValueSource(strings = {"VA0436214792", "HG2015896213"})
        void should_returnTrue_when_serialIsValid(String serial) {
            // given
            // input from ValueSource

            // when
            boolean result = validateEuro(serial);

            // then
            assertThat(result).isTrue();
        }
    }

    @Nested
    class NegativeTests {

        @ParameterizedTest
        @ValueSource(strings = {"UB5067129430", "YZ8630148532", "DA8374810231"})
        void should_returnFalse_when_serialIsInvalid(String serial) {
            // given
            // input from ValueSource

            // when
            boolean result = validateEuro(serial);

            // then
            assertThat(result).isFalse();
        }
    }
}