package app;

public class TaskThread extends Thread{
    private String title;

    public TaskThread(String title) {
        this.title = title;
    }

    @Override
    public void run() {
        System.out.println("старт " + title);
        for (int i = 0; i < 10; i++) {
            System.out.println(title + ": " + i);
        }
        System.out.println("Финиш " + title);
    }
}
