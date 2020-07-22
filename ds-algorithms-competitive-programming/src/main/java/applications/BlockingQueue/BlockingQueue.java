package applications.BlockingQueue;

import utils.LoggingUtil;
import java.util.ArrayList;

public class BlockingQueue {
    private ArrayList<Integer> list;
    private static final int DEFAULT_SIZE = 5;
    private int size;
    final Object lock = new Object();

    BlockingQueue(int size) {
        list = new ArrayList<>();
        this.size = size;
    }

    BlockingQueue() {
        list = new ArrayList<>();
        this.size = DEFAULT_SIZE;
    }


    public void enqueue(int value) throws InterruptedException {
        synchronized (lock) {
            while (list.size() == this.size) {
                lock.wait();
            }

            list.add(value);
            LoggingUtil.logNewLine("Value", value, "added", ", current size:", list.size());
            lock.notifyAll();
        }
    }

    public void dequeue() throws InterruptedException {
        synchronized (lock) {
            while (list.size() == 0) {
                lock.wait();
            }
            lock.notifyAll();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int value = list.remove(0);
            LoggingUtil.logNewLine("Value", value, "removed", ", current size:", list.size());
        }
    }

    public String toString() {
        return list.toString();
    }
}
