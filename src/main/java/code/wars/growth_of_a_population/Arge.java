package code.wars.growth_of_a_population;

public class Arge {

    public static int nbYear(int initialPopulation, double growthPercentage, int externalHabitants, int target) {

        if (initialPopulation >= target) return 0; // already at target

        if (growth(initialPopulation, growthPercentage, externalHabitants) <= 0) return -1; // no growth

        return passYear(initialPopulation, growthPercentage, externalHabitants, target, 1);
    }

    private static int passYear(int initialPopulation, double growthPercentage, int externalHabitants, int target, int year) {

        final int newPopulation = initialPopulation + growth(initialPopulation, growthPercentage, externalHabitants);

        return newPopulation >= target ?
                year :
                passYear(newPopulation, growthPercentage, externalHabitants, target, year + 1);
    }

    private static int growth(int population, double growthPercentage, int externalOscillation) {

        return (int) (population * growthPercentage / 100) + externalOscillation;
    }
}
