package core.java.practise;

import core.java.serialization.Person;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Tester {
    Tester(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {

        int x =10;
        System.out.println(x++);
        x =10;
        System.out.println(++x);

        int a = 10;//1010
        System.out.println(a>>3);


        try {
            Class<?> cls = Class.forName("core.java.practise.Tester");
            try {
                Tester t = (Tester) cls.getDeclaredConstructor(String.class).newInstance("Tanmay");
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            ;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        SortedSet set = new TreeSet();
        set.add(4);
        set.add(3);
        set.add(2);
        set.add(1);
        System.out.println(set);

    }
}
