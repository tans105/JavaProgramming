package core.java.multithreading.callableandfuture;

import java.util.concurrent.*;

public class App2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();

        Future<Integer> future = executor.submit(new Callable<>() {
            @Override
            public Integer call() throws Exception {
                return 10;
            }
        });

        System.out.println(future.get());
    }
}
