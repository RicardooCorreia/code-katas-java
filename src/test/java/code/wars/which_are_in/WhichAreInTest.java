package code.wars.which_are_in;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WhichAreInTest {

    @Test
    public void inArray_whenIsSubstring_returnSubStrings() {

        // Given
        final String[] a = new String[]{"arp", "live", "strong"};
        final String[] b = new String[]{"lively", "alive", "harp", "sharp", "armstrong"};

        // When
        final String[] result = WhichAreIn.inArray(a, b);

        // Then
        assertThat(result)
                .containsExactly("arp", "live", "strong");
    }

    @Test
    public void inArray_whenTheresNoSubstrings_returnEmpty() {

        // Given
        final String[] a = new String[]{"tarp", "mice", "bull"};
        final String[] b = new String[]{"lively", "alive", "harp", "sharp", "armstrong"};

        // When
        final String[] result = WhichAreIn.inArray(a, b);

        // Then
        assertThat(result)
                .isEmpty();
    }

    @Test
    public void inArray_whenIsPartialSubstring_returnSubStrings() {

        // Given
        final String[] a = new String[]{"tarp", "live", "bull"};
        final String[] b = new String[]{"lively", "alive", "harp", "sharp", "armstrong"};

        // When
        final String[] result = WhichAreIn.inArray(a, b);

        // Then
        assertThat(result)
                .containsExactly("live");
    }

    @Test
    public void inArray_whenIsSubstring_returnSortedSubStrings() {

        // Given
        final String[] a = new String[]{"strong", "arp", "live"};
        final String[] b = new String[]{"lively", "alive", "harp", "sharp", "armstrong"};

        // When
        final String[] result = WhichAreIn.inArray(a, b);

        // Then
        assertThat(result)
                .containsExactly("arp", "live", "strong");
    }
}
