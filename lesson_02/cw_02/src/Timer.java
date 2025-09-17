import java.time.LocalTime;

public class Timer implements Runnable {
private int timeOut = 2;

    public int getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }

    @Override
    public void run() {

        while (true){
            System.out.println(LocalTime.now());
            try {
                Thread.sleep(timeOut*1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
