package kr.co.oreb.algorithm.chapter07;

import org.junit.jupiter.api.Test;

public class Chapter07Test {

    @Test
    void sequentialSearchTest() {
        SequentialSearch sequentialSearch = new SequentialSearch();
        sequentialSearch.execute();
    }

    @Test
    void binarySearchTest() {
        BinarySearch binarySearch = new BinarySearch();
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        binarySearch.execute(array, 9);
    }

}
