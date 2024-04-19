package code.wars.how_many_arguments;

import java.util.Arrays;

class Arguments {
    public static int countArgs(Object... args) {

        return (int) Arrays.stream(args)
                .count();
    }
}
