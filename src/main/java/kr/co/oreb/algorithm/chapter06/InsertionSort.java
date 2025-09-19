package kr.co.oreb.algorithm.chapter06;

import java.util.Arrays;

public class InsertionSort {

    public void execute(int[] array) {

        for (int i = 1; i < array.length; i++) {

            int a = array[i];//끼워 넣을 값

            int j;

            for (j = i - 1; j >= 0; j--) {

                int b = array[j];//비교 할 값

                if (a < b) {
                    //끼워 넣을 값이 더 작다면 오른쪽으로 밀기(자리확보)
                    array[j + 1] = array[j];
                } else {
                    //끼워넣을 값보다 큰값을 만나면 break;
                    break;
                }
            }

            //값 끼워넣기
            array[j + 1] = a;
        }

        System.out.println(Arrays.toString(array));

    }

}
