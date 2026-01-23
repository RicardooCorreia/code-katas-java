package code.wars.findTheMine;

public class MineFinder {

    public static int[] findMine(int[][] field){

        for (int x = 0; x < field.length; x++) {
            int[] row = field[x];
            for (int y = 0; y < row.length; y++) {
                if (row[y] == 1) {
                    return new int[] {x, y};
                }
            }
        }
        return new int[] {};
    }
}

