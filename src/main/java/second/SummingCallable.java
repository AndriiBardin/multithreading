package second;

import java.util.List;
import java.util.concurrent.Callable;

public class SummingCallable implements Callable<Integer> {
    private final List<Integer> list;

    public SummingCallable(List<Integer> list) {
        this.list = list;
    }

    @Override
    public Integer call() throws Exception {
        return list.stream().reduce(0, Integer::sum);
    }
}
