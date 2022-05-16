package core.java.multithreading.ThreadCreate;

public class CounterUsingRunnableInterface {
    public static void main(String[] args) {
        Thread t = new Thread(new Runner());
        Thread t1 = new Thread(new Runner());
        t.start();
        t1.start();
    }
}

class Runner implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + 1);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
