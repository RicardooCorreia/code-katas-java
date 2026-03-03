package code.wars.ones_and_zeros;

import java.util.List;

public class BinaryArrayToNumber {

    public static int ConvertBinaryArrayToInt(List<Integer> binary) {


        int result = 0;
        for (int i = 0; i < binary.size(); i++) {
            if (binary.get(i) == 1) {
                int pow = binary.size() - i - 1;
                result += (int) Math.pow(2, pow);
            }
        }
        return result;
    }
}
