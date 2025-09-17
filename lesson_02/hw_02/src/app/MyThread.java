package app;

public class MyThread extends Thread {
private int number;
private int res = number;

    public MyThread(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("Начинаю перечислять числа, делящиеся на " + number);
        while(!isInterrupted()){
            res += number;
            System.out.println("Число, делящееся на " + number + ": " + res + "; ");
        }
        System.out.println("Заканчиваю перечислять числа, делящиеся на " + number);
    }
}
