package app2;

import java.util.Random;
import java.util.random.RandomGenerator;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Random random = new Random();
        for (int i = 0; i < 1000000; i++)
            MyThread.intArr[i] = random.nextInt(10000);

//        MyThread myThread1 = new MyThread(0,999_999);

        MyThread myThread1 = new MyThread(0,199_999);
        MyThread myThread2 = new MyThread(200_000,399_999);
        MyThread myThread3 = new MyThread(400_000,599_999);
        MyThread myThread4 = new MyThread(600_000,799_999);
        MyThread myThread5 = new MyThread(800_000,999_999);


        long start = System.nanoTime();

//        myThread1.start();
//        myThread1.join();

        myThread1.start();
        myThread2.start();
        myThread3.start();
        myThread4.start();
        myThread5.start();
        myThread1.join();
        myThread2.join();
        myThread3.join();
        myThread4.join();
        myThread5.join();


        long stop = System.nanoTime();

        System.out.println(MyThread.summTotal);
        System.out.println("Общее время: " + (stop-start)/1000000 + " мс");

    }
}
