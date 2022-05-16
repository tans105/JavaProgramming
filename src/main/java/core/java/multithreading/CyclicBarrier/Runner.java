package core.java.multithreading.CyclicBarrier;

import java.util.concurrent.*;

public class Runner {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3);
        ExecutorService executors = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++) {
            executors.submit(new Process(barrier));
        }

        executors.shutdown();

    }

}
