package second;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import org.apache.commons.collections4.ListUtils;

public class SummingForkJoin extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 100000;

    private List<Integer> list;

    public SummingForkJoin(List<Integer> list) {
        this.list = list;
    }

    @Override
    protected Integer compute() {
        if (list.size() > THRESHOLD) {
            return ForkJoinTask.invokeAll(subLists()).stream().mapToInt(ForkJoinTask::join).sum();
        }
        return processing(list);
    }

    private Collection<SummingForkJoin> subLists() {
        List<List<Integer>> parts = ListUtils.partition(list, THRESHOLD);
        List<SummingForkJoin> tasks = new ArrayList<>();
        for (List<Integer> part : parts) {
            tasks.add(new SummingForkJoin(part));
        }
        return tasks;
    }

    private Integer processing(List<Integer> numbers) {
        return numbers.stream().reduce(0, Integer::sum);
    }
}
