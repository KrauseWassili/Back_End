/*
Реализовать 2 потока:
первый поток должен выводить на экран все числа от 0 до [сколько успеет], которые делятся на 2;
второй поток должен выводить все числа которые делятся на 3;
Main должен запускать оба эти потока, засыпать на 3 секунды и завершать выполнение программы (т.е. оба потока тоже должны прекратить свою работу)

 */

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Task div2 = new Task(2);
        Task div3 = new Task(3);

        div2.start();
        div3.start();

        Thread.sleep(3000);

        System.out.println("------- game over ------------");




    }
}
