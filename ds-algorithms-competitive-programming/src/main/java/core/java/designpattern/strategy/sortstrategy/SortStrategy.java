package core.java.designpattern.strategy.sortstrategy;

import core.java.designpattern.strategy.sorts.Sort;

public class SortStrategy {
    private Sort strategy;
    private int[] arr;

    public SortStrategy(int[] arr) {
        this.arr = arr;
    }

    public void runSort(Sort sort) {
        sort.sort(arr);
    }
}
