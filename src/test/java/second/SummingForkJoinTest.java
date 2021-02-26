package second;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class SummingForkJoinTest {
    private List<Integer> list;
    private SummingForkJoin summingForkJoin;
    private Integer res;


    @Test
    public void sumOk() {
        list = ListGenerator.getList(6);
        summingForkJoin = new SummingForkJoin(list);
        res = 15;
        assertEquals(res, summingForkJoin.compute());

        list = ListGenerator.getList(13);
        summingForkJoin = new SummingForkJoin(list);
        res = 78;
        assertEquals(res, summingForkJoin.compute());

        list = ListGenerator.getList(101);
        summingForkJoin = new SummingForkJoin(list);
        res = 5050;
        assertEquals(res, summingForkJoin.compute());
    }
}
