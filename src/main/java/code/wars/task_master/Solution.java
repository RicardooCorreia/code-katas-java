package code.wars.task_master;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class Solution {

    static int taskMaster(Collection<Callable<Integer>> functions) {
        int sum = 0;
        ExecutorService executorService = Executors.newFixedThreadPool(functions.size());
        List<Future<Integer>> futures = new ArrayList<>();
        for (var function : functions) {
            Future<Integer> future = executorService.submit(function);
            futures.add(future);
        }

        for (Future<Integer> future : futures) {
            try {
                sum += future.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        return sum;
    }
}

