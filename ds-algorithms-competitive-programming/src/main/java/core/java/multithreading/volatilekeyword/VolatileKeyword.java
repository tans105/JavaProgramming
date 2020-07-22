package core.java.multithreading.VolatileKeyword;


public class VolatileKeyword {

    public static void main(String[] args) {
        VolatileData volatileData = new VolatileData();
        MyThread t1 = new MyThread(volatileData);
        MyThread2 t2 = new MyThread2(volatileData);
        t1.start();
        t2.start();
    }
}

class MyThread extends Thread {
    VolatileData data;

    MyThread(VolatileData running) {
        this.data = running;
    }

    public void run() {
        while (data.getCounter() < 2) {
            System.out.println("Hello...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class MyThread2 extends Thread {
    private VolatileData data;

    MyThread2(VolatileData running) {
        this.data = running;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(2000);
                System.out.println("Incrementing counter...");
                this.data.increaseCounter();
                if (this.data.getCounter() == 3) break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


