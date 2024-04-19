package code.wars.fix_me_hello;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Dinglemouse {

    public static final String FEMALE = "female";

    public static final String MALE = "male";

    private final Map<Attribute, Map.Entry<String, Integer>> values = new HashMap<>();

    private Integer order = 0;

    public Dinglemouse() {

    }

    public Dinglemouse setAge(int age) {

        if (age > 0) {
            addValue(String.valueOf(age), Attribute.AGE);
        }
        return this;
    }

    public Dinglemouse setSex(char sex) {

        if (isMale(sex)) {
            addValue(MALE, Attribute.SEX);
        } else if (isFemale(sex)) {
            addValue(FEMALE, Attribute.SEX);
        }
        return this;
    }

    public Dinglemouse setName(String name) {

        if (!name.isBlank()) {
            addValue(name, Attribute.NAME);
        }
        return this;
    }

    private void addValue(String value, Attribute attribute) {

        Map.Entry<String, Integer> stringIntegerEntry = values.get(attribute);
        if (stringIntegerEntry == null) {
            values.put(attribute, Map.entry(value, order++));
        } else {
            values.put(attribute, Map.entry(value, stringIntegerEntry.getValue()));
        }
    }

    public String hello() {

        return ("Hello. " + values.entrySet().stream()
                .sorted(Comparator.comparingInt(o -> o.getValue().getValue()))
                .toList()
                .stream()
                .map(attributeEntryEntry -> attributeEntryEntry.getKey().formatAttribute(attributeEntryEntry.getValue().getKey()))
                .collect(Collectors.joining(" ")))
                .trim();
    }

    private static boolean isMale(char sex) {

        return sex == 'm' || sex == 'M';
    }

    private static boolean isFemale(char sex) {

        return sex == 'f' || sex == 'F';
    }

    private enum Attribute {
        NAME(value -> String.format("My name is %s.", value)),
        AGE(value -> String.format("I am %s.", value)),
        SEX(value -> String.format("I am %s.", value));

        private final Function<String, String> formatAttribute;

        Attribute(Function<String, String> formatAttribute) {

            this.formatAttribute = formatAttribute;
        }

        public String formatAttribute(String value) {

            return this.formatAttribute.apply(value);
        }
    }
}
