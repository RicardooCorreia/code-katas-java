package code.wars.cat_years_Dog_years_2;


public class Dinglemouse {

    public static int[] ownedCatAndDog(final int catYears, final int dogYears) {

        return new int[]{getYears(catYears, PetRace.CAT), getYears(dogYears, PetRace.DOG)};
    }

    private static int getYears(int petYears, PetRace pet) {

        if (petYears < 15) return 0;
        if (petYears < 24) return 1;

        int extra = (pet == PetRace.DOG) ? 5 : 4;
        return 2 + (petYears - 24) / extra;
    }

    enum PetRace {
        CAT, DOG
    }
}
