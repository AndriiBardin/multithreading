public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        CustomRunnable runnable = new CustomRunnable(counter);
        CustomThread myThread = new CustomThread(counter);
        new Thread(runnable).start();
        myThread.start();
    }
}
