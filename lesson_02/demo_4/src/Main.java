public class Main {
    public static void main(String[] args) throws InterruptedException {
        /*
        Counter.value =100;
        Counter.print();

        Counter c1 = new Counter();
        Counter c2 = new Counter();

        c1.value = 10000;
        Counter.print();
        c2.value = 77773;
        Counter.print();
        */

        MyTask t1 = new MyTask();
        MyTask t2 = new MyTask();
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        Counter.print();

    }
}
