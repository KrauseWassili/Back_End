public class MyThread extends Thread {
    // Общий ресурс на все трэды
    public static int[] intArr = new int[1000000];
    //public static long summTotal = 0;
    //

    final private int startIndex;
    final private int endIndex;
    private long summ = 0;

    public long getSumm() {
        return summ;
    }

    MyThread(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        //System.out.println("Начинаю суммировать элементы с " + startIndex + " по " + endIndex);
        for (int i = startIndex; i <= endIndex; i++) {
            summ += intArr[i];
        }
        //System.out.println("Сумма элементов с " + startIndex + " по " + endIndex + " равна " + summ);
    }
}
