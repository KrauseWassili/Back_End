import java.util.ArrayList;
import java.util.List;

public class Orders {
    public static final int N_THREADS = 3;
    public static final int N_ORDERS = 1000;
    public  static  int COUNTER = 0;

    private final static List<String> orders = new ArrayList<>();
    private final static Object lock = new Object();



    public static void main(String[] args) {

        Runnable task = () -> {
            for (int i = 0; i < N_ORDERS; i++) {
                synchronized (lock) {

                    String order = String.format("%s: заказ %d ", Thread.currentThread().getName(), ++COUNTER);
                    orders.add(order);
                }
            }
        };

        Thread[] threads = new Thread[N_THREADS];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(task,"Manager "+i);
        }

        for (var thread:threads){
            thread.start();
        }

        for (var thread:threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Ожидаемое количество заказов: " + (N_THREADS*N_ORDERS));
        System.out.println("Реальное количество заказов: " + orders.size());
        System.out.println("Подсчитанное количество: " + COUNTER);

    }
}
