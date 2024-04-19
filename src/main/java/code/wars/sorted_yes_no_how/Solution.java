package code.wars.sorted_yes_no_how;

public class Solution {

    public static String isSortedAndHow(int[] array) {

        Order order = null;
        int previous = array[0];
        for (int i = 1; i < array.length; i++) {
            final int current = array[i];

            if (order == null) {
                if (current != previous) {
                    order = current > previous ? Order.ASCENDING : Order.DESCENDING;
                }
            } else {
                if ((order == Order.ASCENDING && current < previous) || (order == Order.DESCENDING && current > previous)) {
                    return "no";
                }
            }
        }

        return "yes, " + order.name;
    }

    public enum Order {
        ASCENDING("ascending"),
        DESCENDING("descending");

        private final String name;


        Order(String name) {
            this.name = name;
        }
    }
}
