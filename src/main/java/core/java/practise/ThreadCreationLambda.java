package core.java.practise;

import utils.LoggingUtil;

public class ThreadCreationLambda {
    public static void main(String[] args) {
        Runnable run = () -> {
            for (int i = 0; i < 10; i++) {
                LoggingUtil.logNewLine("Index : ", i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread = new Thread(run);
        thread.start();
//        thread.start(); //throws illegal state exception
    }
}
