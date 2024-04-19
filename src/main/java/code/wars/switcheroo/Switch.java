package code.wars.switcheroo;

public class Switch {

    public static final String A = "a";
    public static final String B = "b";
    public static final String TEMP = "-";

    public static String switcheroo(String input) {

        return input
                .replaceAll(A, TEMP)
                .replaceAll(B, A)
                .replaceAll(TEMP, B);
    }
}
