package applications.MultithreadedOddEven;

import utils.LoggingUtil;

public class OddNumber implements Runnable{
    LogNumber logger;

    OddNumber(LogNumber logger) {
        this.logger = logger;
    }

    @Override
    public void run() {
        while (true) {
            int counter = logger.printOdd();
            if(counter == -1) break;
            LoggingUtil.logNewLine("Odd Counter", counter);
        }
    }
}
