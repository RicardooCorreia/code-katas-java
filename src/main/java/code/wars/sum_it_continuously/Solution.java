package code.wars.sum_it_continuously;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {
    public static List<Integer> add(List<Integer> list) {

        var runningSum = new AtomicInteger(0);
        return list.stream()
            .map(runningSum::addAndGet)
            .toList();
    }
}
