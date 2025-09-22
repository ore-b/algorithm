package kr.co.oreb.algorithm.chapter08;

public class ToOne {

    public void execute(int x) {

        if (x == 1) {
            return;
        }

        // dp[i] = i를 1로 만드는 최소 연산 횟수
        int[] dp = new int[x + 1];

        //x 가 1인경우 연산이 필요 없음, 0으로 입력
        dp[1] = 0;

        //2부터 시작
        for (int i = 2; i <= x; i++) {

            // -1 은 어떤 숫자에도 가능하니까 기본으로 best를 뽑아 둔다
            // [i-1] 에는 이전 루프서에 계산한 최소 계산값이 있다.
            int best = dp[i - 1] + 1;

            if (i % 2 == 0) {
                best = Math.min(best, dp[i / 2] + 1);
            }

            if (i % 3 == 0) {
                //i/3 위치에 이미 1까지의 최소 계산값이 저장 되어 있으니,
                // 최소 계산값보다 i/3 을 더해야하니 연산 횟수 +1
                int a = dp[i / 3] + 1;
                best = Math.min(best, a);
            }

            if (i % 5 == 0) {
                best = Math.min(best, dp[i / 5] + 1);
            }

            dp[i] = best;
        }

        // 필요하면 출력
        System.out.println(dp[x]);
    }

}
