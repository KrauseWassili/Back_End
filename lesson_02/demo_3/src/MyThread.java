public class MyThread extends  Thread{
    @Override
    public void run() {
        while (!isInterrupted()){
            System.out.println("Поток работает");
            double l=1;
            for (int i = 1; i < 1000000000; i++) {
                l+=i/10.2;
            }
            System.out.println(l);
            /*try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Поток прерван во время сна!");
                break;
            }*/

        }
        System.out.println("Thread finish");
    }
}
