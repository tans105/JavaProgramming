package core.java.practise.waitnotify;

public class Runner {
    public static void main(String[] args) {
        DataTransferUtil util = new DataTransferUtil();
        Thread sender = new Thread(new Sender(util));
        Thread receiver = new Thread(new Receiver(util));

        sender.start();
        receiver.start();
    }
}
