package miniApplications.oddeven;

public class LogNumber {
    int counter = 0;
    boolean isOdd = true;
    final int limit = 10;
    final Object lock = new Object();

    public int printOdd() {
        synchronized (lock) {
            while (!isOdd) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            isOdd = false;
            try {
                Thread.sleep(1000);
                counter++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.notify();
        }
        return (counter < limit) ? counter : -1;

    }


    public int printEven() {
        synchronized (lock) {
            while (isOdd) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            isOdd = true;

            try {
                Thread.sleep(1000);
                counter++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.notify();
        }
        return (counter < limit) ? counter : -1;

    }
}
