package core.java.practise.waitnotify;

public class DataTransferUtil {
    private boolean canTransfer = true;
    String packet;

    public synchronized void send(String packet) {
        while (!canTransfer) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        canTransfer = false;
        this.packet = packet;
        notifyAll();
    }

    public synchronized String receive() {
        while (canTransfer) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        canTransfer = true;
        notifyAll();
        return packet;
    }
}
