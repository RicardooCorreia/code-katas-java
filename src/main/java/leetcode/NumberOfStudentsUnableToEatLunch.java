package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class NumberOfStudentsUnableToEatLunch {

    /**
     * The school cafeteria offers circular and square sandwiches at lunch break, referred to by numbers 0 and 1 respectively. All students stand in a queue. Each student either prefers square or circular sandwiches.
     * The number of sandwiches in the cafeteria is equal to the number of students. The sandwiches are placed in a stack. At each step:
     *  If the student at the front of the queue prefers the sandwich on the top of the stack, they will take it and leave the queue.
     *  Otherwise, they will leave it and go to the queue's end.
     *  This continues until none of the queue students want to take the top sandwich and are thus unable to eat.
     * You are given two integer arrays students and sandwiches where sandwiches[i] is the type of the ith sandwich in the stack (i = 0 is the top of the stack) and students[j] is the preference of the j​​​​​​th student in the initial queue (j = 0 is the front of the queue). Return the number of students that are unable to eat.
     * <p>
     * Example 1:
     *      Input: students = [1,1,0,0], sandwiches = [0,1,0,1]
     *      Output: 0
     *      Explanation:
     *      - Front student leaves the top sandwich and returns to the end of the line making students = [1,0,0,1].
     *      - Front student leaves the top sandwich and returns to the end of the line making students = [0,0,1,1].
     *      - Front student takes the top sandwich and leaves the line making students = [0,1,1] and sandwiches = [1,0,1].
     *      - Front student leaves the top sandwich and returns to the end of the line making students = [1,1,0].
     *      - Front student takes the top sandwich and leaves the line making students = [1,0] and sandwiches = [0,1].
     *      - Front student leaves the top sandwich and returns to the end of the line making students = [0,1].
     *      - Front student takes the top sandwich and leaves the line making students = [1] and sandwiches = [1].
     *      - Front student takes the top sandwich and leaves the line making students = [] and sandwiches = [].
     *      Hence all students are able to eat.
     * Example 2:
     *      Input: students = [1,1,1,0,0,1], sandwiches = [1,0,0,0,1,1]
     *      Output: 3
     * <p>
     * Constraints:
     *      1 <= students.length, sandwiches.length <= 100
     *      students.length == sandwiches.length
     *      sandwiches[i] is 0 or 1.
     *      students[i] is 0 or 1.
     */
    static class Solution {
        public int countStudents(int[] students, int[] sandwiches) {

            List<Integer> studentQueue = Arrays.stream(students).boxed().collect(Collectors.toCollection(LinkedList::new));
            List<Integer> sandwichesQueue = Arrays.stream(sandwiches).boxed().collect(Collectors.toCollection(LinkedList::new));

            int skippedStudent = 0;
            while (!studentQueue.isEmpty() && skippedStudent != studentQueue.size()) {

                Integer student = studentQueue.remove(0);
                Integer sandwich = sandwichesQueue.get(0);
                if (student.equals(sandwich)) {
                    sandwichesQueue.remove(0);
                    skippedStudent = 0;
                } else {
                    studentQueue.add(student);
                    skippedStudent++;
                }
            }
            return studentQueue.size();
        }
    }
}
