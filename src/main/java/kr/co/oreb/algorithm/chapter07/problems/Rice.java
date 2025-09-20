package kr.co.oreb.algorithm.chapter07.problems;

public class Rice {

    //n : 떡갯수
    //m : 요청한 길이
    //array : 떡 길이
    public void execute(int n, int m, int[] array) {

        int start = 0;//떡길이 최소
        int end = 0;//떡길이 최대

        for (int i = 0; i < n; i++) {
            if (end < array[i]) {
                end = array[i];
            }
        }

        //최종 H
        int hight = -1;

        while (start <= end) {

            //떡칼 길이 중간
            int mid = (start + end) / 2;

            int length = 0;

            for (int i = 0; i < array.length; i++) {

                int remain = array[i] - mid;

                if (remain > 0) {
                    length += remain;
                }
            }

            if (m <= length) {
                //떡의 길이가 요청한 길이가 확보됨.
                //칼의 길이를 늘리면서 최적의 값 찾기
                hight = mid;
                start = mid + 1;
            } else {
                //떡의 길이가 요청한 길이보다 작다면, 칼길이를 줄이자
                end = mid - 1;
            }

        }

        System.out.println(hight);

    }

}
