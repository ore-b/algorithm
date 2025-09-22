package kr.co.oreb.algorithm.chapter08;

import java.util.Arrays;

public class Coin {

    private static final int INF = Integer.MAX_VALUE;

    public void execute(int[] coins, int m) {

        int result = solve(coins, m);

        System.out.println(result);

    }

    //array : 화폐단위, m : 목표금액
    private int solve(int[] coins, int m) {

        int[] dp = new int[m + 1];

        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int coin : coins) {                      // 화폐단위 하나 선택
            for (int x = coin; x <= m; x++) {         // 그 동전으로 만들 수 있는 금액들 확인

                if (dp[x - coin] != INF) {
                    //x원에서 coin 금액만큼 뺀 금액에 코인갯수가 있다는 것은, coin 만 더하면 현재 x 를 만들 수 있다는것
                    // x-coin != INF 가 아니라는 것은, 현재의 coin 으로 x 금액을 만들 수 있다는 것

                    int candidate = dp[x - coin] + 1; // 거기에 이 동전 1개를 더하면 x원을 만들 수 있음

                    if (candidate < dp[x]) {          // 지금 기록된 값보다 더 적은 개수라면
                        dp[x] = candidate;            // 더 좋은(작은) 값으로 갈아끼우기
                    }
                }

            }
        }

        int result = dp[m];

        return result == INF ? -1 : result;

    }
}
