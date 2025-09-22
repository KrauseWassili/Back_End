public class MyTask extends Thread {
    private int n = 10000;
    @Override
    public void run() {
        for (int i = 0; i < n ; i++) {
            Counter.increase();
        }

    }
}
