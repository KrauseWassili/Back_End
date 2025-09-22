public class Task extends  Thread{

    private final  int factor;

    public Task(int factor) {
        this.factor = factor;
        this.setDaemon(true);
    }

    @Override
    public void run() {
        for (int i = 0; true ; i+=factor) {
            System.out.printf(" Делится на %d: %d%n",factor, i);


        }
    }
}
