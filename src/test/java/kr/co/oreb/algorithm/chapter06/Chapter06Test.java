package kr.co.oreb.algorithm.chapter06;

import org.junit.jupiter.api.Test;

public class Chapter06Test {

    @Test
    public void selectionSortTest() {
        SelectionSort selectionSort = new SelectionSort();

        int[] array = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
        selectionSort.execute(array);
    }

    @Test
    public void insertionSortTest() {
        InsertionSort insertionSort = new InsertionSort();

        int[] array = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
        insertionSort.execute(array);
    }

    @Test
    void quickSortTest() {
        QuickSort quickSort = new QuickSort();
        int[] array = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
        quickSort.execute(array);
    }


}
