package second;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.apache.commons.collections4.ListUtils;

public class SummingExecutorService {
    private static final int THREADS = 4;
    private final List<Integer> list;

    public SummingExecutorService(List<Integer> list) {
        this.list = list;
    }

    public Integer getSum(List<Integer> list) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS);
        List<Callable<Integer>> callables = new ArrayList<>();
        int listPartSize = list.size() / THREADS;
        List<List<Integer>> parts = ListUtils.partition(list, listPartSize);
        for (List<Integer> part : parts) {
            callables.add(new SummingCallable(part));
        }
        int sum = 0;
        try {
            List<Future<Integer>> futures = executorService.invokeAll(callables);
            for (Future<Integer> numbers : futures) {
                sum += numbers.get();
            }
            return sum;
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("Something went wrong ", e);
        } finally {
            executorService.shutdown();
        }
    }
}
