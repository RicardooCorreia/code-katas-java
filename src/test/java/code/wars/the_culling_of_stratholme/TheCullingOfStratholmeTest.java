package code.wars.the_culling_of_stratholme;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TheCullingOfStratholmeTest {

    @Test
    public void testOneWord() {
        String input = "String";
        System.out.println("input: " + input);
        assertThat(TheCullingOfStratholme.purify(input)).isEqualTo("Stg");
    }

    @Test
    public void testOneWord2() {
        String input = "BatChesting";
        System.out.println("input: " + input);
        assertThat(TheCullingOfStratholme.purify(input)).isEqualTo("BatChesg");
    }

    @Test
    public void testNumbers() {
        String input = "Iron Maiden";
        System.out.println("input: " + input);
        assertThat(TheCullingOfStratholme.purify(input)).isEqualTo("on Men");
    }

    @Test
    public void testNepalTea() {
        String input = "The tea in Nepal is very hot";
        System.out.println("input: " + input);
        assertThat(TheCullingOfStratholme.purify(input)).isEqualTo("The tea Nepal very hot");
    }

    @Test
    public void testWhitespaces() {
        String input = "IIIIiiiiiiIIIII";
        System.out.println("input: " + input);
        assertThat(TheCullingOfStratholme.purify(input)).isEqualTo("");
    }

    @Test
    public void testWhitespaces2() {
        String input = "";
        System.out.println("input: " + input);
        assertThat(TheCullingOfStratholme.purify(input)).isEqualTo("");
    }

    @Test
    public void test() {
        String input = "1i2i 33 i4i5 55ii5";
        System.out.println("input: " + input);
        assertThat(TheCullingOfStratholme.purify(input)).isEqualTo("33 5");
    }

}
