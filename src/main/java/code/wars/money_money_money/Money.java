package code.wars.money_money_money;

public class Money {

    public static int calculateYears(double principal, double interest, double tax, double desired) {

        int years = 0;
        double current = principal;
        while (current < desired) {
            double gains = current * interest;
            double taxed = gains * tax;
            current += gains - taxed;
            years++;
        }

        return years;
    }
}
