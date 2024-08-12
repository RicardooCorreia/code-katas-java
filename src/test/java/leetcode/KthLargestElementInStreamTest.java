package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KthLargestElementInStreamTest {

    @Test
    void test() {

        // Given
        KthLargestElementInStream.KthLargest subject = new KthLargestElementInStream.KthLargest(3, new int[]{4, 5, 8, 2});

        // When
        int result1 = subject.add(3);
        int result2 = subject.add(5);
        int result3 = subject.add(10);
        int result4 = subject.add(9);
        int result5 = subject.add(4);

        // Then
        assertThat(result1).isEqualTo(4);
        assertThat(result2).isEqualTo(5);
        assertThat(result3).isEqualTo(5);
        assertThat(result4).isEqualTo(8);
        assertThat(result5).isEqualTo(8);
    }

    @Test
    void edgeCase() {

        // Given
        KthLargestElementInStream.KthLargest subject = new KthLargestElementInStream.KthLargest(1, new int[]{});

        // When
        int result1 = subject.add(-3);
        int result2 = subject.add(-2);
        int result3 = subject.add(-4);
        int result4 = subject.add(0);
        int result5 = subject.add(4);

        // Then
        assertThat(result1).isEqualTo(-3);
        assertThat(result2).isEqualTo(-2);
        assertThat(result3).isEqualTo(-2);
        assertThat(result4).isEqualTo(0);
        assertThat(result5).isEqualTo(4);
    }

    @Test
    void edgeCase2() {

        // Given
        KthLargestElementInStream.KthLargest subject = new KthLargestElementInStream.KthLargest(2, new int[]{0});

        // When
        int result1 = subject.add(-1);
        int result2 = subject.add(1);
        int result3 = subject.add(-2);
        int result4 = subject.add(-4);
        int result5 = subject.add(3);

        // Then
        assertThat(result1).isEqualTo(-1);
        assertThat(result2).isEqualTo(0);
        assertThat(result3).isEqualTo(0);
        assertThat(result4).isEqualTo(0);
        assertThat(result5).isEqualTo(1);
    }
}