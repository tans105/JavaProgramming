package utils;

import java.lang.reflect.Array;
import java.util.List;

public class LoggingUtil {

    public static void log(Object... arguments) {
        StringBuilder format = new StringBuilder();
        for (Object argument : arguments) {
            format.append("%s ");
        }
        System.out.format(format.toString(), arguments);
    }

    public static void logNewLine(Object... arguments) {
        log(arguments);
        System.out.println();
    }

    public static void logTabSeparated(Object value) {
        System.out.print(value + "\t");
    }

    public static void logCollection(List<?> list) {
        if (list == null || list.size() == 0) return;

        Object ele = list.get(0);
        Class<?> eleClass = ele.getClass();
        int eleLength = 0;
        boolean isArray = false;

        if (eleClass.isArray()) {
            isArray = true;
            eleLength = Array.getLength(ele);
        }

        for (Object obj : list) {
            if (isArray) {
                StringBuilder builder = new StringBuilder();
                builder.append("[");

                for (int i = 0; i < eleLength; i++) {
                    Object element = Array.get(obj, i);
                    builder.append(element);
                    builder.append(",");
                }

                builder.deleteCharAt(builder.length() - 1);
                builder.append("]");
                logTabSeparated(builder);
            } else {
                logTabSeparated(obj);
            }
        }
        System.out.println();
    }
}
