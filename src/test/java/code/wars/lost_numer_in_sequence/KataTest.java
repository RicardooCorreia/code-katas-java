package code.wars.lost_numer_in_sequence;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KataTest {

    @Test
    void returns_deleted_number_from_short_sequence() {
        // given
        var arr = new int[]{1, 2, 3, 4, 5};
        var mixedArr = new int[]{3, 4, 1, 5};

        // when
        var result = Kata.findDeletedNumber(arr, mixedArr);

        // then
        assertThat(result).isEqualTo(2);
    }

    @Test
    void returns_deleted_number_from_long_sequence() {
        // given
        var arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        var mixedArr = new int[]{1, 9, 7, 4, 6, 2, 3, 8};

        // when
        var result = Kata.findDeletedNumber(arr, mixedArr);

        // then
        assertThat(result).isEqualTo(5);
    }

    @Test
    void returns_zero_when_no_number_deleted() {
        // given
        var arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        var mixedArr = new int[]{5, 7, 6, 9, 4, 8, 1, 2, 3};

        // when
        var result = Kata.findDeletedNumber(arr, mixedArr);

        // then
        assertThat(result).isEqualTo(0);
    }
}