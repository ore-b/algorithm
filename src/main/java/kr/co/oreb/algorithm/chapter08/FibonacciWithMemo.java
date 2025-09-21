package kr.co.oreb.algorithm.chapter08;

import java.util.Arrays;
import kr.co.oreb.algorithm.Description;

public class FibonacciWithMemo {

    private long[] dp;

    public void execute(int n) {

        dp = new long[n + 1];
        Arrays.fill(dp, -1);

        long result = fibonacci(n);

        System.out.println(result);
    }

    @Description("재귀")
    private long fibonacci(int n) {

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        if (dp[n] != -1) {
            System.out.println("hit f(" + n + ")");
            return dp[n];
        }

        dp[n] = fibonacci(n - 1) + fibonacci(n - 2);

        return dp[n];
    }

}
