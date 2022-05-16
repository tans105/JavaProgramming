package applications.multithreadedoddeven;

import utils.LoggingUtil;

public class EvenNumber implements Runnable {
    LogNumber logger;

    EvenNumber(LogNumber logger) {
        this.logger = logger;
    }

    @Override
    public void run() {
        while (true) {
            int counter = logger.printEven();
            if(counter == -1) break;
            LoggingUtil.logNewLine("Even Counter", counter);
        }
    }
}
