package code.wars.how_many_arguments;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;

class ArgumentsTest {

    @Test
    public void sampleTest() {

        assertThat(Arguments.countArgs(1, 2, 3))
                .isEqualTo(3);
        assertThat(Arguments.countArgs(1, 2, "uhsaf uas"))
                .isEqualTo(3);
        assertThat(Arguments.countArgs(1))
                .isEqualTo(1);
        assertThat(Arguments.countArgs('a', 865, "asfhgajsf", new BigInteger("123456")))
                .isEqualTo(4);
        assertThat(Arguments.countArgs())
                .isEqualTo(0);
    }
}
