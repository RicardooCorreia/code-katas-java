package code.wars.calculate_mean_and_concatenate_string;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KataTest {

    @Test
    public void mean_shouldCalculateMeanAndConcatenateString_forMixedDigitsAndLetters1() {
        // given
        char[] input = new char[]{
            'u',
            '6',
            'd',
            '1',
            'i',
            'w',
            '6',
            's',
            't',
            '4',
            'a',
            '6',
            'g',
            '1',
            '2',
            'w',
            '8',
            'o',
            '2',
            '0'
        };
        Object[] expectedResult = new Object[]{3.6, "udiwstagwo"};

        // when
        Object[] actualResult = Kata.mean(input);

        // then
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void mean_shouldCalculateMeanAndConcatenateString_forMixedDigitsAndLetters2() {
        // given
        char[] input = new char[]{
            '0',
            'c',
            '7',
            'x',
            '6',
            '2',
            '3',
            '5',
            'w',
            '7',
            '0',
            'y',
            'v',
            'u',
            'h',
            'i',
            'n',
            'u',
            '0',
            '0'
        };
        Object[] expectedResult = new Object[]{3.0, "cxwyvuhinu"};

        // when
        Object[] actualResult = Kata.mean(input);

        // then
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void mean_shouldCalculateMeanAndConcatenateString_forMixedDigitsAndLetters3() {
        // given
        char[] input = new char[]{
            '0',
            'u',
            'a',
            'y',
            '0',
            'a',
            '9',
            'q',
            '3',
            'v',
            'g',
            '7',
            '6',
            '4',
            'y',
            'd',
            '8',
            '6',
            '0',
            'd'
        };
        Object[] expectedResult = new Object[]{4.3, "uayaqvgydd"};

        // when
        Object[] actualResult = Kata.mean(input);

        // then
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void mean_shouldCalculateMeanAndConcatenateString_forMixedDigitsAndLetters4() {
        // given
        char[] input = new char[]{
            's',
            'n',
            '9',
            'l',
            '0',
            'm',
            'i',
            'z',
            '9',
            '7',
            'y',
            '4',
            'z',
            '3',
            '3',
            'k',
            '4',
            '1',
            '0',
            'k'
        };
        Object[] expectedResult = new Object[]{4.0, "snlmizyzkk"};

        // when
        Object[] actualResult = Kata.mean(input);

        // then
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void mean_shouldCalculateMeanAndConcatenateString_forMixedDigitsAndLetters5() {
        // given
        char[] input = new char[]{
            '5',
            'v',
            'u',
            'k',
            '8',
            '4',
            '9',
            'b',
            '9',
            'g',
            '5',
            'z',
            '3',
            'f',
            '6',
            'u',
            'i',
            '6',
            '6',
            't'
        };
        Object[] expectedResult = new Object[]{6.1, "vukbgzfuit"};

        // when
        Object[] actualResult = Kata.mean(input);

        // then
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void mean_shouldCalculateMeanAndConcatenateString_forLowMeanAndAllLettersAtEnd() {
        // given
        char[] input = new char[]{
            '1',
            '1',
            '1',
            '1',
            '1',
            '1',
            '1',
            '1',
            '1',
            '0',
            'a',
            'a',
            'd',
            'd',
            'g',
            'q',
            'u',
            'v',
            'y',
            'y'
        };
        Object[] expectedResult = new Object[]{0.9, "aaddgquvyy"};

        // when
        Object[] actualResult = Kata.mean(input);

        // then
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void mean_shouldCalculateMeanAndConcatenateString_forExactIntegerMeanAndAllLettersAtEnd() {
        // given
        char[] input = new char[]{
            '1',
            '1',
            '1',
            '1',
            '1',
            '1',
            '1',
            '1',
            '1',
            '1',
            'a',
            'a',
            'd',
            'd',
            'g',
            'q',
            'u',
            'v',
            'y',
            'y'
        };
        Object[] expectedResult = new Object[]{1.0, "aaddgquvyy"};

        // when
        Object[] actualResult = Kata.mean(input);

        // then
        assertThat(actualResult).isEqualTo(expectedResult);
    }
}