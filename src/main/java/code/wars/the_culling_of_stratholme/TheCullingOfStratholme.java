package code.wars.the_culling_of_stratholme;

public class TheCullingOfStratholme {

    public static String purify(String s) {

        final char[] citizens = s.toCharArray();
        char lastCitizen = ' ';
        final StringBuilder cleanPopulation = new StringBuilder();
        for (int i = 0; i < citizens.length; i++) {

            final char currentCitizen = citizens[i];
            if (currentCitizen == 'i' || currentCitizen == 'I') {
                removeLastCitizenFromCleanPopulation(lastCitizen, cleanPopulation);
            } else if (currentCitizen != ' ' && (lastCitizen == 'i' || lastCitizen == 'I')) {
                lastCitizen = ' ';
                continue;
            } else {
                cleanPopulation.append(currentCitizen);
            }
            lastCitizen = currentCitizen;
        }

        return cleanPopulation.toString()
                .trim()
                .replaceAll("\\s+", " ");
    }

    private static void removeLastCitizenFromCleanPopulation(char lastCitizen, StringBuilder cleanPopulation) {
        if (lastCitizen != ' ') {
            final int lastCitizenIndex = cleanPopulation.lastIndexOf(String.valueOf(lastCitizen));
            if (lastCitizenIndex != -1)
                cleanPopulation.deleteCharAt(lastCitizenIndex);
        }
    }
}
