package kr.co.oreb.algorithm.chapter03.greedy;

import java.util.Arrays;

public class BigNumber {


    /***
     *
     * @param numbers : 숫자 배열
     * @param m : 더하는 횟수
     * @param k : 같은 수를 연속으로 더 하는 최대 횟수
     */
    public void process(int[] numbers, int m, int k) {

        Arrays.sort(numbers);

        int firstNumber = numbers[numbers.length - 1];
        int secondNumber = numbers[numbers.length - 2];

        int total = 0;

        for (int i = 0; i < m; i++) {

            if (i != 0 && i % k == 0) {
                total += secondNumber;
            } else {
                total += firstNumber;
            }

        }

        System.out.println(total);

    }

}
