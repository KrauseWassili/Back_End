import java.util.Random;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        int size = 1_000_000;
        int parts = 4;
        MyThread[] threads = new MyThread[parts];
        int summTotal = 0;

        Random random = new Random();
        for (int i = 0; i < size; i++)
            MyThread.intArr[i] = 1; //random.nextInt(10000);

        // создаем массив threads
        for (int i = 0; i < parts; i++) {
            int[] range = getRange(size, parts, i);
            threads[i] = new MyThread(range[0], range[1]);
        }

        long start = System.nanoTime();

        for (var thread: threads){
            thread.start();
        }

        for (var thread: threads){
            thread.join();
        }


        for (var thread:threads){
            summTotal += thread.getSumm();
        }
        long stop = System.nanoTime();

        System.out.println(summTotal);
        System.out.println("Общее время: " + (stop-start)/1000000 + " мс");

    }

    public static int[] getRange(int arraySize, int parts, int partIndex){
        int baseSize = arraySize/parts;

        int start = baseSize * partIndex;
        int end = start+baseSize -1;

        return new int[]{start,end};

    }







}
