package competitiveProgramming.random;


import java.util.*;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import java.util.stream.Stream;

/*

 */
public class Test {
    public static class superclass {
        void print()
        {
            System.out.println("print in superclass.");
        }
    }
    public static class subclass extends superclass {
        void print()
        {
            System.out.println("print in subclass.");
        }
    }

    public static void main(String[] args)
    {
        superclass A = new superclass();
        superclass B = new subclass();
        A.print();
        B.print();
    }

}
