package app;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread2 = new MyThread(2);
        MyThread myThread3 = new MyThread(3);
        System.out.println("Старт app.Main()");

        myThread2.start();
        myThread3.start();

        Thread.sleep(30);

        myThread2.interrupt();
        myThread3.interrupt();
        System.out.println("Стоп app.Main()");
    }
}
