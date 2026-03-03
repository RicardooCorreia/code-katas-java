package code.wars.ones_and_zeros;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryArrayToNumberTest {

    @Test
    void convertBinaryArrayToInt_whenBinary0001_return1() {

        // Given
        final ArrayList<Integer> input = new ArrayList<>(Arrays.asList(0, 0, 0, 1));

        // When
        final int result = BinaryArrayToNumber.ConvertBinaryArrayToInt(input);

        // Then
        assertThat(result)
                .isEqualTo(1);
    }

    @Test
    void convertBinaryArrayToInt_whenBinary1111_return15() {

        // Given
        final ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1, 1, 1, 1));

        // When
        final int result = BinaryArrayToNumber.ConvertBinaryArrayToInt(input);

        // Then
        assertThat(result)
                .isEqualTo(15);
    }

    @Test
    void convertBinaryArrayToInt_whenBinary0110_return6() {

        // Given
        final ArrayList<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 1, 0));

        // When
        final int result = BinaryArrayToNumber.ConvertBinaryArrayToInt(input);

        // Then
        assertThat(result)
                .isEqualTo(6);
    }

    @Test
    void convertBinaryArrayToInt_whenBinary1001_return9() {

        // Given
        final ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1, 0, 0, 1));

        // When
        final int result = BinaryArrayToNumber.ConvertBinaryArrayToInt(input);

        // Then
        assertThat(result)
                .isEqualTo(9);
    }
}
