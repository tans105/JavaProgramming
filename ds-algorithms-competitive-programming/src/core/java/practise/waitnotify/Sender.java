package core.java.practise.waitnotify;

import utils.LoggingUtil;

public class Sender implements Runnable {
    DataTransferUtil util;

    Sender(DataTransferUtil util) {
        this.util = util;
    }

    @Override
    public void run() {
        String[] packets = new String[]{"A", "B", "C", "D", "E", "End"};
        for (String packet : packets) {
            util.send(packet);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LoggingUtil.logNewLine("Packet", packet, "Sent");
        }
    }
}
