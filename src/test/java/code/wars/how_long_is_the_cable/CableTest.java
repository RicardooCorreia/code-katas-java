package code.wars.how_long_is_the_cable;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigInteger;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CableTest {

    @Nested
    class SimpleTests {

        @ParameterizedTest
        @CsvSource({
            "----,4",
            "-__-,6",
            "-_=_-,9",
            "(--),4",
            "(-_),6",
            "_(-_),8"
        })
        void returnsCorrectLength_forSimpleCable(String input, long expected) {
            // when
            var result = Cable.calculateLength(input);

            // then
            assertThat(result).isEqualTo(BigInteger.valueOf(expected));
        }
    }

    @Nested
    class HarderTests {

        @ParameterizedTest
        @CsvSource({
            "_(-(_))=,15",
            "_((=)((-))(_))=,33"
        })
        void returnsCorrectLength_forHarderCable(String input, long expected) {
            // when
            var result = Cable.calculateLength(input);

            // then
            assertThat(result).isEqualTo(BigInteger.valueOf(expected));
        }
    }
}
