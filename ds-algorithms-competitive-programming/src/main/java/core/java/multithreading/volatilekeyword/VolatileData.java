package core.java.multithreading.VolatileKeyword;

public class VolatileData {
    private volatile int counter = 0;

    public int getCounter() {
        return counter;
    }

    public void increaseCounter() {
        counter = counter + 1;      //increases the value of counter by 1
    }
}
