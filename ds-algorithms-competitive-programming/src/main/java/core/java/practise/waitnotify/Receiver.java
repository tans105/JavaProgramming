package core.java.practise.waitnotify;

import utils.LoggingUtil;

public class Receiver implements Runnable {

    DataTransferUtil util;

    public Receiver(DataTransferUtil util) {
        this.util = util;
    }

    @Override
    public void run() {
        while (true) {
            String receivedMessage = util.receive();
            LoggingUtil.logNewLine("Packet", receivedMessage, "received");
            if (receivedMessage.equalsIgnoreCase("END")) break;
        }
    }
}
