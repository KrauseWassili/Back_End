public class MyThread extends Thread{

    @Override
    public void run() {
        while (!isInterrupted()){
            System.out.println("Поток работает");
            long l=0;
            for (int i = 0;  i < 100000; i++) {
                l+=i;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Поток прерван во время сна!");
                break;
            }
        }
    }
}
