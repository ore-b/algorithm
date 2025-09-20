package kr.co.oreb.algorithm.chapter06;

public class CountSort {

    public void execute(int[] array) {

        int[] count = new int[array.length];

        for (int i : array) {
            count[i]++;
        }

        for (int i = 0; i < array.length; i++) {

            int c = count[i];

            for (int j = 0; j < c; j++) {
                System.out.print(i + " ");
            }
        }

    }

}
