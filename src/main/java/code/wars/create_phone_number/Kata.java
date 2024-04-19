package code.wars.create_phone_number;

import java.util.Arrays;

public class Kata {

    public static String createPhoneNumber(int[] numbers) {

        final Object[] boxedArray = Arrays.stream(numbers)
                .limit(10)
                .boxed()
                .toArray();

        return String.format("(%d%d%d) %d%d%d-%d%d%d%d", boxedArray);
    }
}