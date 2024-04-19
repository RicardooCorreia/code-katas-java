package code.wars.circular_list;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CircularListTest {

    @Test
    public void circularListTest() {

        final CircularList<String> xs = new CircularList<>("one", "two", "three");
        assertThat(xs.next()).isEqualTo("one");
        assertThat(xs.next()).isEqualTo("two");
        assertThat(xs.next()).isEqualTo("three");
        assertThat(xs.next()).isEqualTo("one");
        assertThat(xs.prev()).isEqualTo("three");
        assertThat(xs.prev()).isEqualTo("two");
        assertThat(xs.prev()).isEqualTo("one");
        assertThat(xs.prev()).isEqualTo("three");

        final CircularList<Integer> ys = new CircularList<>(1, 2, 3, 4, 5);
        assertThat(ys.prev()).isEqualTo(5);
        assertThat(ys.prev()).isEqualTo(4);
        assertThat(ys.next()).isEqualTo(5);
        assertThat(ys.next()).isEqualTo(1);
        assertThat(ys.next()).isEqualTo(2);
        assertThat(ys.next()).isEqualTo(3);
        assertThat(ys.next()).isEqualTo(4);
        assertThat(ys.prev()).isEqualTo(3);
        assertThat(ys.prev()).isEqualTo(2);
        assertThat(ys.next()).isEqualTo(3);
        assertThat(ys.next()).isEqualTo(4);
        assertThat(ys.next()).isEqualTo(5);
        assertThat(ys.next()).isEqualTo(1);
        assertThat(ys.next()).isEqualTo(2);
        assertThat(ys.next()).isEqualTo(3);
    }
}
