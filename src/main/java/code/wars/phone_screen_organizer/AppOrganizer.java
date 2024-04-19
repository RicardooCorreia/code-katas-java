package code.wars.phone_screen_organizer;

import java.util.Arrays;

public class AppOrganizer {

    public static Object[] moveOver(Object[] a) {

        int i = 0, j = a.length - 1;
        while (i <= j) {
            if (a[i] != null) {
                i++;
            } else if (a[j] == null) {
                j--;
            } else {
                a[i] = a[j];
                a[j] = null;
            }
        }
        return java.util.Arrays.copyOfRange(a, 0, j + 1);
    }
}
