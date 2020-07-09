package competitiveProgramming.random;

import java.util.ArrayList;
import java.util.Iterator;

public class OverrideToStringList {
    public static void main(String[] args) {
        CustomArrayList<String> list = new CustomArrayList<>();
        list.add(1);
        list.add(2);
        System.out.println(list);
    }
}

class CustomArrayList<T> extends ArrayList {

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Iterator itr = super.listIterator();
        while (itr.hasNext()) {
            builder.append(itr.next()).append("\n");
        }
        return builder.toString();
    }
}

