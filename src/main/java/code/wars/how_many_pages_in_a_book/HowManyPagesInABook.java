package code.wars.how_many_pages_in_a_book;

public class HowManyPagesInABook {

    public static int amountOfPages(int summary) {

        int length = 0;
        int currentNumber = 1;
        while (length != summary) {
            length += String.valueOf(currentNumber).length();
            currentNumber++;
        }
        return currentNumber - 1;
    }
}
