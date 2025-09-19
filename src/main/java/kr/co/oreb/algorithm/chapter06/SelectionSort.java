package kr.co.oreb.algorithm.chapter06;

import java.util.Arrays;

public class SelectionSort {

    public void execute(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {

            //최소값 인덱스
            int minIndex = i;

            for (int j = i + 1; j < array.length; j++) {

                if (array[j] < array[minIndex]) {
                    //현재 인덱스보다 더 작은값 인덱스를 찾았다면 저장
                    minIndex = j;
                }

            }

            if (i != minIndex) {
                //i 보다 최소값을 찾았다면 스왑
                int tmp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = tmp;
            }
        }

        System.out.println(Arrays.toString(array));
    }

}
