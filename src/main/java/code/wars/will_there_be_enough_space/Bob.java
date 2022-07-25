package code.wars.will_there_be_enough_space;

public class Bob {
    public static int enough(int cap, int on, int wait) {

        return Math.max((on + wait) - cap, 0);
    }
}
