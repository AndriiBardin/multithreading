public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Runnable runnable = new CustomRunnable(counter);
        Thread myThread = new CustomThread(counter);
        new Thread(runnable).start();
        myThread.start();
    }
}
