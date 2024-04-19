package code.wars.maximum_product;

public class MaxProduct {
    public int adjacentElementsProduct(int[] array) {

        int maximum = Integer.MIN_VALUE;
        for (int i = 1; i < array.length; i++) {

            int current = array[i - 1] * array[i];
            if (current > maximum) {
                maximum = current;
            }
        }
        return maximum;
    }
}
