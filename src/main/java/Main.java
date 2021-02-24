public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread runnable = new Thread(new CustomRunnable(counter));
        CustomThread myThread = new CustomThread(counter);
        runnable.start();
        myThread.start();
    }
}
