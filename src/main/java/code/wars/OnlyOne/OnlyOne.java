package code.wars.OnlyOne;

public class OnlyOne {
    public static boolean onlyOne(Boolean... args) {

        boolean found = false;

        for (Boolean arg : args) {
            if (arg && found) {
                return false;
            } else if(arg) {
                found = true;
            }
        }

        return found;
    }
}
