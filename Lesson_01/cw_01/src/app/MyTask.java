package app;

public class MyTask implements Runnable{
private String title;

    public MyTask(String title) {
        this.title = title;
    }

    @Override
    public void run() {
        System.out.println("Thread, созданный черзе interface Runnable");
        System.out.println("старт " + title);
        for (int i = 0; i < 10; i++) {
            System.out.println(title + ": " + i);
        }
        System.out.println("Финиш " + title);
    }
}
