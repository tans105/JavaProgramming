package core.java.practise;

import utils.LoggingUtil;

import java.util.Date;
import java.util.concurrent.*;

public class FastestThread {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Long>[] futures = new Future[3];

        for (int i = 0; i < 3; i++) {
            int finalI = i;
            futures[i] = executor.submit(() -> {
                Date d1 = new Date();
                try {
                    //some process
                    Thread.sleep((finalI + 1) * 1000);
                    //
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Date d2 = new Date();
                return d2.getTime() - d1.getTime();
            });
        }


        long first;
        long second;
        long third;

        try {
            first = futures[0].get();
            second = futures[1].get();
            third = futures[2].get();
            LoggingUtil.logNewLine("Time Lapsed", "Thread 1", first, "Thread 2", second, "Thread 3", third);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();

    }
}
