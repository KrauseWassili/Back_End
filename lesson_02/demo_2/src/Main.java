import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Timer timer = new Timer();
        Thread timerThread = new Thread(timer);
        timerThread.setDaemon(true);
        timerThread.start();

        while (true){
            System.out.println("нажмите 'q' для выхода");
            String input = scanner.nextLine();
            if (input.equals("q")){
                break;
            } else {
                try {
                    int newTimeOut = Integer.parseInt(input);
                    timer.setTimeOut(newTimeOut);
                } catch (Exception e){

                }
            }
        }

        System.out.println("Main завершен");

    }
}
