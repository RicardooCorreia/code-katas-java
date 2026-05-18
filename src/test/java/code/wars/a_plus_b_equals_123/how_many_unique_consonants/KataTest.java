package code.wars.a_plus_b_equals_123.how_many_unique_consonants;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KataTest {

    @Test
    void counts_unique_consonants_in_simple_word() {
        assertThat(Kata.countConsonants("sillystring")).isEqualTo(7);
    }

    @Test
    void counts_zero_when_only_vowels() {
        assertThat(Kata.countConsonants("aeiou")).isEqualTo(0);
    }

    @Test
    void counts_all_consonants_in_alphabet() {
        assertThat(Kata.countConsonants("abcdefghijklmnopqrstuvwxyz")).isEqualTo(21);
    }

    @Test
    void ignores_case_and_non_letters() {
        assertThat(Kata.countConsonants("Count my unique consonants!!")).isEqualTo(7);
    }

    @Test
    void counts_zero_for_empty_string() {
        assertThat(Kata.countConsonants("")).isEqualTo(0);
    }
}