import org.apache.log4j.Logger;

public class CustomRunnable implements Runnable {
    private static final Logger logger = Logger.getLogger(CustomThread.class);
    private final Counter counter;

    public CustomRunnable(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        while (counter.getCount() < 100) {
            logger.info("Runnable " + counter.increment());
        }
    }
}
