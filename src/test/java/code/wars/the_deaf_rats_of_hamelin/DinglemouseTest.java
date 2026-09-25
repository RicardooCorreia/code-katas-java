package code.wars.the_deaf_rats_of_hamelin;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static code.wars.the_deaf_rats_of_hamelin.Dinglemouse.countDeafRats;
import static org.assertj.core.api.Assertions.assertThat;

class DinglemouseTest {

    @ParameterizedTest
    @CsvSource(value = {
        "~O~O~O~O P,0",
        "P O~ O~ ~O O~,1",
        "~O~O~O~OP~O~OO~,2",
    })
    public void countDeafRats_examples(
        // given
        String input,
        int expected) {

        // when
        var result = countDeafRats(input);

        // then
        assertThat(result)
            .isEqualTo(expected);
    }
}
