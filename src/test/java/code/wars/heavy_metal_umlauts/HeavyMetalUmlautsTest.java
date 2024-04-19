package code.wars.heavy_metal_umlauts;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HeavyMetalUmlautsTest {

    @Test
    public void heavyMetalUmlauts_test1() {

        // Given
        final String input = "Announcing the Macbook Air Guitar";

        // When
        final String result = HeavyMetalUmlauts.heavyMetalUmlauts(input);


        // Then
        assertThat(result)
                .isEqualTo("\u00c4nn\u00f6\u00fcnc\u00efng th\u00eb M\u00e4cb\u00f6\u00f6k \u00c4\u00efr G\u00fc\u00eft\u00e4r");
    }

    @Test
    public void heavyMetalUmlauts_test2() {

        // Given
        final String input = "Facebook introduces new heavy metal reaction buttons";

        // When
        final String result = HeavyMetalUmlauts.heavyMetalUmlauts(input);


        // Then
        assertThat(result)
                .isEqualTo("F\u00e4c\u00ebb\u00f6\u00f6k \u00efntr\u00f6d\u00fcc\u00ebs n\u00ebw h\u00eb\u00e4v\u00ff m\u00ebt\u00e4l r\u00eb\u00e4ct\u00ef\u00f6n b\u00fctt\u00f6ns");
    }

    @Test
    public void heavyMetalUmlauts_test3() {

        // Given
        final String input = "Strong sales of Google's VR Metalheadsets send tech stock prices soaring";

        // When
        final String result = HeavyMetalUmlauts.heavyMetalUmlauts(input);


        // Then
        assertThat(result)
                .isEqualTo("Str\u00f6ng s\u00e4l\u00ebs \u00f6f G\u00f6\u00f6gl\u00eb's VR M\u00ebt\u00e4lh\u00eb\u00e4ds\u00ebts s\u00ebnd t\u00ebch st\u00f6ck pr\u00efc\u00ebs s\u00f6\u00e4r\u00efng");
    }

    @Test
    public void heavyMetalUmlauts_test4() {

        // Given
        final String input = "Vegan Black Metal Chef hits the big time on Amazon TV";

        // When
        final String result = HeavyMetalUmlauts.heavyMetalUmlauts(input);


        // Then
        assertThat(result)
                .isEqualTo("V\u00ebg\u00e4n Bl\u00e4ck M\u00ebt\u00e4l Ch\u00ebf h\u00efts th\u00eb b\u00efg t\u00efm\u00eb \u00f6n \u00c4m\u00e4z\u00f6n TV");
    }
}
