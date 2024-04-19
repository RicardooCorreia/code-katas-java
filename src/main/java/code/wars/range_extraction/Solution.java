package code.wars.range_extraction;

class Solution {

    public static final String COMMA = ",";
    public static final String DASH = "-";

    public static String rangeExtraction(int[] arr) {

        int startRange = arr[0];
        int lastValue = arr[0];
        final StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < arr.length; i++) {
            final int currentValue = arr[i];
            startRange = appendValuesIfRangeIsBrokenAndGetNewStartRange(startRange, lastValue, stringBuilder, currentValue);
            lastValue = currentValue;
        }
        appendValuesToString(startRange, lastValue, stringBuilder);
        return stringBuilder.toString();
    }

    private static int appendValuesIfRangeIsBrokenAndGetNewStartRange(int startRange,
                                                                      int lastValue,
                                                                      StringBuilder stringBuilder,
                                                                      int currentValue) {

        final boolean rangeIsBroken = currentValue - lastValue != 1;
        if (rangeIsBroken) {
            appendValuesToString(startRange, lastValue, stringBuilder);
            stringBuilder.append(COMMA);
            return currentValue;
        }
        return startRange;
    }

    private static void appendValuesToString(int startRange, int lastValue, StringBuilder stringBuilder) {

        if (startRange == lastValue) {
            stringBuilder.append(lastValue);
        } else if (startRange == lastValue - 1) {
            stringBuilder.append(startRange).append(COMMA).append(lastValue);
        } else {
            stringBuilder.append(startRange).append(DASH).append(lastValue);
        }
    }
}
