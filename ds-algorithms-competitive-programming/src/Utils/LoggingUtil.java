package utils;

public class LoggingUtil {

    public static void log(Object... arguments) {
        StringBuilder format = new StringBuilder();
        for (Object argument : arguments) {
            format.append("%s ");
        }
        System.out.format(format.toString(), arguments);
    }

    public static void logNewLine(Object... arguments) {
        StringBuilder format = new StringBuilder();
        for (Object argument : arguments) {
            format.append("%s ");
        }
        System.out.format(format.toString(), arguments);
        System.out.println();
    }
}
