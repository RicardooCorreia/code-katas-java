package code.wars.going_to_the_cinema;

public class Movie {

    public static int movie(int card, int ticket, double perc) {

        int count = 0;
        double ticketPrice = ticket;
        double totalSpent = card;
        do {
            ticketPrice *= perc;
            totalSpent += ticketPrice;
            count++;
        } while (Math.round(totalSpent) > (long) ticket * count);
        return count;
    }
}
