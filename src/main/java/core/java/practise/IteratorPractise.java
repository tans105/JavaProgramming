package core.java.practise;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class IteratorPractise implements Iterable<Integer> {
    public static void main(String[] args) {
        IteratorPractise practise = new IteratorPractise(10);
        practise.add(1);
        practise.add(2);

        for (Integer i : practise) {
            System.out.print(i + "\t");
        }
    }

    private Integer[] array;
    private static final int DEFAULT_SIZE = 10;
    private int currentIndex = 0;

    IteratorPractise() {
        array = new Integer[DEFAULT_SIZE];
    }

    IteratorPractise(int size) {
        array = new Integer[size];
    }

    public void add(int val) {
        array[currentIndex] = val;
        this.currentIndex++;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            private int itrIndex = 0;

            @Override
            public boolean hasNext() {
                return this.itrIndex != array.length;
            }

            @Override
            public Integer next() {
                if (this.itrIndex < array.length - 1 && null != array[this.itrIndex]) {
                    return array[this.itrIndex++];
                } else {
                    this.itrIndex++;
                    return 0;
                }
            }
        };
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {

    }

    @Override
    public Spliterator<Integer> spliterator() {
        return null;
    }
}
