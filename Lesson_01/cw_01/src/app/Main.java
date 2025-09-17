package app;

public class Main {
    public static void main(String[] args) {
        long start = System.nanoTime();
        System.out.println("Старт main()");
        TaskThread t1 = new TaskThread("Jack");
        TaskThread t2 = new TaskThread("John");

        MyTask task1 = new MyTask("Anna");
        Thread t3 = new Thread(task1);

        t1.start();
        t2.start();
        t3.start();

        try{
            t1.join(); //пусть текущий thread (main) подождет выполнения thread t1
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long finish= System.nanoTime();

        System.out.println(finish-start);

        System.out.println("Финиш main() ");
    }
}
