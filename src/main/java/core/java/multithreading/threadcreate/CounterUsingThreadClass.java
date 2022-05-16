package core.java.multithreading.ThreadCreate;

public class CounterUsingThreadClass {
    public static void main(String[] args) {
        Threader threader = new Threader();
        Threader threader2 = new Threader();
        //threader.run(10); //this is not right as it will run thread in the main method thread
        threader.start();
        threader2.start();
    }
}

class Threader extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + 1);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}



