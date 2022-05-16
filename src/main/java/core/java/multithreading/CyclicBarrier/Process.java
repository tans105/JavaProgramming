package core.java.multithreading.CyclicBarrier;

import utils.LoggingUtil;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Process implements Runnable {
    CyclicBarrier barrier;

    Process(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                LoggingUtil.logNewLine(Thread.currentThread().getName(), "waiting");
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
