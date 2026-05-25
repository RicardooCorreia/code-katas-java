package code.wars.even_times_last;

public class Kata {

    public static int evenLast(int[] numbers) {

        if (numbers.length == 0) return 0;

        var total = 0;
        for (var i = 0; i < numbers.length; i += 2) {
            total += numbers[i];
        }

        return total * numbers[numbers.length - 1];
    }
}
