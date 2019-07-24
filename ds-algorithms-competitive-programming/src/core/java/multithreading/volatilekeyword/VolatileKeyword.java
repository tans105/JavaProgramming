package core.java.multithreading.volatilekeyword;

import java.util.Scanner;

public class VolatileKeyword {

    public static void main(String[] args) {
        Threade threade = new Threade();
        threade.start();
        System.out.println("Press enter to terminate..");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        threade.shutdown();
    }
}

class Threade extends Thread {
    private volatile boolean running = true;

    public void run() {
        while (running) {
            System.out.println("Hello...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown() {
        running = false;
    }
}



