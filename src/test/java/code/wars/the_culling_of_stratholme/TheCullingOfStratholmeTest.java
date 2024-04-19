package code.wars.the_culling_of_stratholme;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TheCullingOfStratholmeTest {

    @Test
    public void testOneWord() {
        String input = "String";
        System.out.println("input: " + input);
        assertEquals("Stg", TheCullingOfStratholme.purify(input));
    }

    @Test
    public void testOneWord2() {
        String input = "BatChesting";
        System.out.println("input: " + input);
        assertEquals("BatChesg", TheCullingOfStratholme.purify(input));
    }

    @Test
    public void testNumbers() {
        String input = "Iron Maiden";
        System.out.println("input: " + input);
        assertEquals("on Men", TheCullingOfStratholme.purify(input));
    }

    @Test
    public void testNepalTea() {
        String input = "The tea in Nepal is very hot";
        System.out.println("input: " + input);
        assertEquals("The tea Nepal very hot", TheCullingOfStratholme.purify(input));
    }

    @Test
    public void testWhitespaces() {
        String input = "IIIIiiiiiiIIIII";
        System.out.println("input: " + input);
        assertEquals("", TheCullingOfStratholme.purify(input));
    }

    @Test
    public void testWhitespaces2() {
        String input = "";
        System.out.println("input: " + input);
        assertEquals("", TheCullingOfStratholme.purify(input));
    }

    @Test
    public void test() {
        String input = "1i2i 33 i4i5 55ii5";
        System.out.println("input: " + input);
        assertEquals("33 5", TheCullingOfStratholme.purify(input));
    }

}
