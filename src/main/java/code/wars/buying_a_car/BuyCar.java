package code.wars.buying_a_car;

public class BuyCar {

    public static int[] nbMonths(int startPriceOld, int startPriceNew, int savingPerMonth, double percentLossByMonth) {

        if (startPriceOld >= startPriceNew) {
            return new int[]{0, startPriceOld - startPriceNew};
        }
        return calculateMonth(1, startPriceOld, startPriceNew, 0, savingPerMonth, percentLossByMonth);
    }

    private static int[] calculateMonth(int monthNumber, double priceOld, double priceNew, int savings, int savingPerMonth, double percentLossByMonth) {

        double newPriceOld = calculateNewCarValue(priceOld, percentLossByMonth);
        double newPriceNew = calculateNewCarValue(priceNew, percentLossByMonth);

        int thisMonthSavings = savings + savingPerMonth;
        double difference = newPriceOld + thisMonthSavings - newPriceNew;

        if (difference >= 0) {
            return new int[]{monthNumber, Math.toIntExact(Math.round(difference))};
        }

        final int newMonth = monthNumber + 1;
        return calculateMonth(newMonth, newPriceOld, newPriceNew, thisMonthSavings, savingPerMonth, newMonth % 2 == 0 ? percentLossByMonth + 0.5 : percentLossByMonth);
    }

    private static double calculateNewCarValue(double originalPrice, double percentLoss) {
        return originalPrice - (originalPrice * percentLoss * 0.01);
    }
}
