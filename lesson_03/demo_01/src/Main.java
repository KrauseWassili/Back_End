public class Main {
    public static void main(String[] args) throws InterruptedException {


        MyTask t1 = new MyTask();
        MyTask t2 = new MyTask();
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        Counter.print();

    }
}
