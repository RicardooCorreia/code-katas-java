package code.wars.build_a_square;

// https://www.codewars.com/kata/59a96d71dbe3b06c0200009c/train/java
public class Kata {
    public static final String generateShape(int n) {

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append("+".repeat(n));
            if (i < n - 1) {
                stringBuilder.append("\n");
            }
        }

        return stringBuilder.toString();
    }
}
