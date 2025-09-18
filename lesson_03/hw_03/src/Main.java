import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int orderNumber = 1_000;

        String[] orders = createOrders(orderNumber);
        sendOrders(orders, 10);


        printOrderList();
    }

    private static void printOrderList() {
        for (String order : MyThread.orderList)
            System.out.println(order + ";");
    }

    public static void sendOrders(String[] orders, int threadNumber) {
        int orderNumber = orders.length;
        MyThread[] threadArr = new MyThread[threadNumber];

        for (int i = 0; i < threadNumber; i++) {
            threadArr[i] = new MyThread(orders, i * orderNumber / threadNumber, ((i + 1) * orderNumber / threadNumber));

        }
        for (int i = 0; i < threadNumber; i++) {
            threadArr[i].start();
            try {
                threadArr[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public static String[] createOrders(int numberOfOrders) {
        String[] res = new String[numberOfOrders];
        for (int i = 0; i < numberOfOrders; i++) {
            res[i] = "Заказ № " + (i + 1);
        }
        return res;
    }
}
