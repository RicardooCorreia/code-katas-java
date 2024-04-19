package code.wars.meeting;

import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

class Meeting {

    public static String meeting(String s) {

        return Arrays.stream(s.split(";"))
                .map(s1 -> s1.split(":"))
                .map(strings -> new Person(strings[0], strings[1]))
                .sorted(Person::compareTo)
                .map(Person::toString)
                .collect(Collectors.joining());
    }

    private record Person(String firstName, String lastName) implements Comparable<Person> {


        @Override
        public int compareTo(Person other) {

            final int lastNameCompare = getToUpperCase(this.lastName).compareTo(getToUpperCase(other.lastName));
            return lastNameCompare == 0 ? getToUpperCase(this.firstName).compareTo(getToUpperCase(other.firstName)) : lastNameCompare;
        }

        @Override
        public String toString() {

            return String.format("(%s, %s)", getToUpperCase(lastName), getToUpperCase(firstName));
        }

        private String getToUpperCase(String string) {
            return string.toUpperCase(Locale.ROOT);
        }
    }
}
