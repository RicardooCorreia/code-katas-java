package code.wars.simple_beads_count;

public class BeadsCounter {

    public static int countRedBeads(final int nBlue) {

        if (nBlue == 0) return 0;
        return 2 * (nBlue - 1);
    }
}
