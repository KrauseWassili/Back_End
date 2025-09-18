import java.util.ArrayList;
import java.util.List;

public class MyThread extends Thread {
    public static List<String> orderList = new ArrayList<>();
    final private static Object lock = new Object();

    String[] orders;
    final private int startIndex;
    final private int endIndex;


    public MyThread(String[] orders, int startIndex, int endIndex) {
        this.orders = orders;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }


    @Override
    public void run() {
        //System.out.println("Начинаю добавлять товары " + startIndex + " по " + endIndex);
        for (int i = startIndex; i < endIndex; i++) {

            synchronized (lock) {
                orderList.add(orders[i]);
               // System.out.println("Добавил товар №" + i + ";");
            }

        }
    }
}
