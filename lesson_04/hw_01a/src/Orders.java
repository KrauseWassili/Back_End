import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Orders {
    public static final int N_THREADS = 3;
    public static final int N_ORDERS = 1000;
    public  static AtomicInteger COUNTER = new AtomicInteger(0);

    private final static List<String> orders = Collections.synchronizedList(new ArrayList<>());
    private final static Object lock = new Object();



    public static void main(String[] args) {

        Runnable task = () -> {
            for (int i = 0; i < N_ORDERS; i++) {

                String order = String.format("%s: заказ %d ", Thread.currentThread().getName(), COUNTER.incrementAndGet());
                orders.add(order);

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
