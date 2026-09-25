package code.wars.the_deaf_rats_of_hamelin;

public class Dinglemouse {

    public static int countDeafRats(final String town) {

        final var charArray = town.toCharArray();
        boolean piperFound = false;
        int deafRats = 0;
        for (var i = 0; i < charArray.length; i++) {
            switch (charArray[i]) {
                case 'P' -> piperFound = true;
                case '~' -> { // ~O
                    if (piperFound) {
                        deafRats++;
                    }
                    i++;
                }
                case 'O' -> { // O~
                    if (!piperFound) {
                        deafRats++;
                    }
                    i++;
                }
            }
        }
        return deafRats;
    }
}
