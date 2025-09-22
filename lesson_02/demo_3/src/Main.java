import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        MyThread thread = new MyThread();
        thread.start();
        System.out.println("Введите что нибудь для завершения");
        String s = scanner.nextLine();

        //Thread.sleep(3000);

        System.out.println("Main: завершаем работу трэда thread");
        thread.interrupt();
    }
}
