package second;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListGenerator {
    public static List<Integer> getList(int size) {
        return IntStream.range(0, size)
                .boxed()
                .collect(Collectors.toList());
    }
}
