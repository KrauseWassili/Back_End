public class Main {
    public static void main(String[] args) {
        Demo demo = new Demo() {   // class X implements Demo
            @Override
            public void print() {
                System.out.println("hello from anonymous ");
            }
        };

        var thread = new Thread(){  // class T extends Thread
            @Override
            public void run() {
                System.out.println( "Hello from anonymous Thread!" );
            }
        };
        Runnable task = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
        };
        new Thread(task).start();
        new Thread(()-> System.out.println("еще один трэд")).start();

        thread.start();



    }
}
