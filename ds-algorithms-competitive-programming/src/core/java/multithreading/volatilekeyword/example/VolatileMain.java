package core.java.multithreading.volatilekeyword.example;

public class VolatileMain {

    private final static int noOfThreads = 2;

    public static void main(String[] args) throws InterruptedException {
        VolatileData volatileData = new VolatileData();     //object of VolatileData class
        Thread[] threads = new Thread[noOfThreads];     //creating Thread array
        for (int i = 0; i < noOfThreads; ++i)
            threads[i] = new VolatileThread(volatileData);
        for (int i = 0; i < noOfThreads; ++i)
            threads[i].start();                 //starts all reader threads
        for (int i = 0; i < noOfThreads; ++i)
            threads[i].join();                  //wait for all threads
    }
}