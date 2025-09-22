public class Main {
    public static void main(String[] args)  {
        long start = System.currentTimeMillis();
        System.out.println("старт main()");
        TaskThread t1 = new TaskThread("jack");
        TaskThread t2 = new TaskThread("john");

        // создание thread с помощью интерфейса Runnable
        MyTask task1 = new MyTask("Anna");
        Thread t3 = new Thread(task1);


        t1.start(); // для создания потока вызываем метод start()
        t2.start(); // ОС создает отдельный поток и запускает в нем метод run()
        t3.start();

        try {
            t1.join();   // пусть текущий thread (main) подождет выполнения thread t1
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        long finish = System.currentTimeMillis();

        System.out.println(finish-start);

        System.out.println(finish/1000);
        System.out.println("финиш main()");
    }
}
