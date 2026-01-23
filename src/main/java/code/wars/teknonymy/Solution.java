package code.wars.teknonymy;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    static void teknonymize(Person person) {

        if (hasChildren(person)) {
            findLast(person, 0);
        }
    }

    private static Map.Entry<Integer, Person> findLast(Person person, int level) {

        Map.Entry<Integer, Person> lastDescendent = null;
        for (Person child : person.children) {
            Map.Entry<Integer, Person> current;
            if (hasChildren(child)) {
                current = findLast(child, level + 1);
            } else {
                current = Map.entry(level + 1, child);
            }
            lastDescendent = eldestFromNewerGeneration(lastDescendent, current);
        }

        person.teknonym = buildTeknonymize(level, lastDescendent.getKey(), person.sex, lastDescendent.getValue().name);
        return lastDescendent;
    }

    private static Map.Entry<Integer, Person> eldestFromNewerGeneration(Map.Entry<Integer, Person> person1,
                                                                        Map.Entry<Integer, Person> person2) {

        if (person1 == null || person2.getKey() > person1.getKey()) {
            return person2;
        } else if (person2.getKey().equals(person1.getKey())) {
            if (person2.getValue().dateOfBirth.isBefore(person1.getValue().dateOfBirth)) {
                return person2;
            }
        }
        return person1;
    }

    private static boolean hasChildren(Person person) {
        return person.children != null && person.children.length > 0;
    }

    private static String buildTeknonymize(int parentLevel, int childLevel, Character parentSex, String childName) {

        StringBuilder builder = new StringBuilder(parentSex == 'm' ? "father" : "mother");
        builder.append(" of ").append(childName);
        int difference = childLevel - parentLevel;
        if (difference > 1) {
            builder.insert(0, "grand");
            if (difference > 2) {
                String prefix = IntStream.range(2, difference)
                        .mapToObj(i -> "great-")
                        .collect(Collectors.joining());
                builder.insert(0, prefix);
            }
        }

        return builder.toString();
    }
}

class Person {
    public Person parent;
    public final String name;
    public final Character sex;
    public final Person[] children;
    public final LocalDateTime dateOfBirth;
    public String teknonym = ""; // that's the field you should mutate

    public Person(String name, Character sex, Person[] children, LocalDateTime dateOfBirth) {
        this.name = name;
        this.sex = sex;
        this.children = children;
        this.dateOfBirth = dateOfBirth;
    }
}
