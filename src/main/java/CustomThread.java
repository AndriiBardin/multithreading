import org.apache.log4j.Logger;

public class CustomThread extends Thread {
    private static final Logger logger = Logger.getLogger(CustomThread.class);
    private final Counter counter;

    public CustomThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        while (counter.getCount() < 100) {
            logger.info("Thread " + counter.increment());
        }
    }
}
