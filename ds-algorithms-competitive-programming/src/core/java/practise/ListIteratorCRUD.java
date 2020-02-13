package core.java.practise;

import java.util.*;

public class ListIteratorCRUD {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        System.out.println(list);

        ListIterator<String> itr = list.listIterator();

        while (itr.hasNext()) {
            itr.next();
            itr.set("K");
        }

        System.out.println(list);
    }
}
