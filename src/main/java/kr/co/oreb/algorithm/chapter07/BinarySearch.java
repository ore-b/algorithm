package kr.co.oreb.algorithm.chapter07;

public class BinarySearch {

    public void execute(int[] array, int target) {

//        int targetIndex = search(array, target, 0, array.length - 1);
        int targetIndex = searchOfWhile(array, target);

        System.out.println(targetIndex);
    }

    private int search(int[] array, int target, int start, int end) {

        int mid = start + (end - start) / 2;

        if (array[mid] == target) {
            return mid;
        } else if (array[mid] < target) {
            return search(array, target, mid + 1, end);
        } else {
            return search(array, target, start, mid - 1);
        }
    }

    private int searchOfWhile(int[] array, int target) {

        int start = 0;
        int end = array.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

}
