package kr.co.oreb.algorithm.chapter06;

import java.util.Arrays;

public class QuickSort {

    public void execute(int[] array) {

        quick(array, 0, array.length - 1);

        System.out.println(Arrays.toString(array));
    }

    private static void quick(int[] array, int start, int end) {

        if (start >= end) {
            //start end 포인터가 동일하거나 교차 되었다면 종료
            return;
        }

        //두 포인터를 양 끝에서 시작
        int lPointer = start;
        int rPointer = end;

        // 오버플로우 안전한 가운데 인덱스: left + (right - left) / 2
        int mid = start + (end - start) / 2;
        int pivot = array[mid]; // 피벗 = 가운데 값

        // 1) 파티셔닝: lp 와 rp 가 교차할 때까지 반복
        while (lPointer <= rPointer) {

            // 왼쪽에서부터 피벗 이상(>=)이 나올 때까지 전진
            // 왼쪽에 피벗보다 큰 값이 있으면 오른쪽으로 보내야한다
            while (array[lPointer] < pivot) {
                lPointer++;
            }

            // 오른쪽에서부터 피벗 이하(<=)가 나올 때까지 후퇴
            // 오른쪽에 피벗보다 작은 값이 있으면 왼쪽으로 보내야한다
            while (array[rPointer] > pivot) {
                rPointer--;
            }

            // lPointer <= rPointer 이면
            // lPointer 와 rPointer 의 값이 교차하지 않았다면 정렬이 끝나지 않았음
            // 즉, 잘못된 값 발견, 서로 교환
            // lPointer == rPointer 인 경우에도 들어옴. swap 은 의미가 없지만, 포인터를 ++,-- 하기위함
            if (lPointer <= rPointer) {
                int tmp = array[lPointer];
                array[lPointer] = array[rPointer];
                array[rPointer] = tmp;
                //현재 포인터들까지 스캔 완료, 포인터 이동
                lPointer++;
                rPointer--;
            }
        }

        // 2) 분할된 두 구간을 재귀 정렬
        //    [left .. j]  |  [i .. right]
        quick(array, start, rPointer);
        quick(array, lPointer, end);
    }

}
