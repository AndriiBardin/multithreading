package second;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class SummingExecutorServiceTest {
    private List<Integer> list;
    private SummingExecutorService service;
    private Integer res;


    @Test
    public void sumOk() {
        list = ListGenerator.getList(6);
        service = new SummingExecutorService(list);
        res = 15;
        assertEquals(res, service.getSum(list));

        list = ListGenerator.getList(13);
        service = new SummingExecutorService(list);
        res = 78;
        assertEquals(res, service.getSum(list));

        list = ListGenerator.getList(101);
        service = new SummingExecutorService(list);
        res = 5050;
        assertEquals(res, service.getSum(list));
    }
}
