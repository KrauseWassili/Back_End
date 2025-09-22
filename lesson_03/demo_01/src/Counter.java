public class Counter {
    public  static int value = 0;
    private  static Object lock = new Object();

    public static void print(){
        System.out.println(value);
    }

    public static void increase(){
        synchronized (lock) {
            value++;
        }
    }
}
