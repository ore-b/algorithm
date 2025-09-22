package kr.co.oreb.algorithm.chapter08;

import kr.co.oreb.algorithm.Description;

public class Fibonacci {

    public void execute(int n) {
        fibonacci(n);
        long result = fibonacci2(n);

        System.out.println(result);
    }

    private void fibonacci(int n) {

        long a = 0;
        long b = 1;

        for (int i = 0; i < n; i++) {

            //전값 + 현재값
            long sum = a + b;
            //전값을 현재값으로
            a = b;
            //현재 값을 다음(sum) 값으로
            b = sum;

        }
        //a 가 현재값
        System.out.println(a);
    }

    @Description("재귀")
    private long fibonacci2(int n) {

        System.out.println("f(" + n + ")");

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return fibonacci2(n - 1) + fibonacci2(n - 2);
    }
}
