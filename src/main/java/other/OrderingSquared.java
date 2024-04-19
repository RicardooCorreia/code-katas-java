package other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class OrderingSquared {

    /**
     * The input is a list of ordered numbers in the range of -10000 and 10000
     * Return the square of each number in the input ordered.
     * For example:
     * squareAndOrder([-7,-4,-1,2,3,6,9])
     * should return [1,4,9,16,36,49,81]
     * Params:
     * Input 'numbers' is a list containing the range [10000, 10000], where the length of list does not exceed 10000
     * All input numbers sorted in ascending order
     * Returns:
     * Ordered list of squares
     * Some more examples:
     * squareAndOrder([]) should return []
     * squareAndOrder([2]) should return [4]
     * squareAndOrder([1,2,4]) should return [1, 4, 8]
     * squareAndOrder([-4,-3,-2]) should return [4,9,16]
     * squareAndOrder([-1,1]) should return [1,1]
     * squareAndOrder([-4,-3,-2,0,2,3,4]) should return [0,4,4,9,9,16,16]
     */
    public List<Integer> squareAndOrder(List<Integer> sortedNumbers) {

        var negative = new ArrayList<Integer>(sortedNumbers.size());
        var positive = new ArrayList<Integer>(sortedNumbers.size());
        var result = new ArrayList<Integer>(sortedNumbers.size());
        sortedNumbers.forEach(n -> {
            if (n < 0) negative.add(-n);
            else positive.add(n);
        });
        Collections.reverse(negative);
        int ip = 0, in = 0;
        while (ip < positive.size() || in < negative.size()) {
            var n = in < negative.size() ? negative.get(in) : Integer.MAX_VALUE;
            var p = ip < positive.size() ? positive.get(ip) : Integer.MAX_VALUE;
            if (n < p) {
                result.add((int) Math.pow(n, 2));
                in++;
            } else {
                result.add((int) Math.pow(p, 2));
                ip++;
            }
        }
        return result;
    }
}
