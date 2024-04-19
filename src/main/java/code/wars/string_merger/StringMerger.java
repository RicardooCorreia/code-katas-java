package code.wars.string_merger;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Supplier;

public class StringMerger {

    public static boolean isMerge(String s, String part1, String part2) {

        if (part1.length() + part2.length() != s.length()) {
            return false;
        }

        final Queue<Character> queuePart1 = createQueue(part1);
        final Queue<Character> queuePart2 = createQueue(part2);

        char[] charArray = s.toCharArray();

        return mergeString(charArray, 0, queuePart1, queuePart2);
    }

    private static boolean mergeString(char[] charArray, int letterIndex, Queue<Character> queuePart1, Queue<Character> queuePart2) {

        if (letterIndex == charArray.length) {
            return true;
        }

        final char letter = charArray[letterIndex];
        final boolean queuesAreNotEmpty = !queuePart1.isEmpty() && !queuePart2.isEmpty();
        final Supplier<Boolean> queuesHaveSameNextElement = () -> queuePart1.element() == queuePart2.element();
        if (queuesAreNotEmpty && queuesHaveSameNextElement.get() && queuePart1.element() == letter) {

            final LinkedList<Character> copy1 = new LinkedList<>(queuePart1);
            final LinkedList<Character> copy2 = new LinkedList<>(queuePart2);

            copy1.remove();
            copy2.remove();
            return mergeString(charArray, letterIndex + 1, copy1, queuePart2)
                    || mergeString(charArray, letterIndex + 1, queuePart1, copy2);

        } else {
            return normalFlow(charArray, letterIndex, queuePart1, queuePart2, letter);
        }
    }

    private static boolean normalFlow(char[] charArray, int letterIndex, Queue<Character> queuePart1, Queue<Character> queuePart2, char letter) {

        if (!queuePart1.isEmpty() && queuePart1.element() == letter) {
            queuePart1.remove();
            return mergeString(charArray, letterIndex + 1, queuePart1, queuePart2);
        } else if (!queuePart2.isEmpty() && letter == queuePart2.element()) {
            queuePart2.remove();
            return mergeString(charArray, letterIndex + 1, queuePart1, queuePart2);
        } else {
            return false;
        }
    }

    private static Queue<Character> createQueue(String part1) {
        final LinkedList<Character> queuePart = new LinkedList<>();
        for (char letter : part1.toCharArray()) {
            queuePart.add(letter);
        }
        return queuePart;
    }
}
