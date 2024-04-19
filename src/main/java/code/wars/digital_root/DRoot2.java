package code.wars.digital_root;

public class DRoot2 {

    public static int digital_root(int n) {

        return (n != 0 && n % 9 == 0) ? 9 : n % 9;
    }
}
