package kr.co.oreb.algorithm.chapter08;

public class Tile {

    /*
     * 2 x n 보드를
     *  - 세로 타일(2x1)
     *  - 가로 타일(1x2)
     *  - 정사각형 타일(2x2)
     * 로 채우는 "경우의 수"를 반환 (mod 796,796)
     */
    public void execute(int n) {

        int solve = solve(n);

        System.out.println(solve);
    }

    private int solve(int n) {
        if (n == 1) {
            //직사각형이 2 X 1 인 경우, 세로타일 한개
            return 1;
        }

        if (n == 2) {
            //직사각형이 2 X 2 인 경우, 3가지 경우의 수
            // [2x1 + 2x1], [1x2 + 1x2], [2x2]
            return 3;
        }

        // d[i] = 2 x i 보드를 채우는 경우의 수
        int[] d = new int[n + 1];

        d[1] = 1;
        d[2] = 3;

        for (int i = 3; i <= n; i++) {

            // 마지막 한 열을 "세로(2x1)"로 붙이면 → d[i-1], 1 가지경우의 수 ( *1 생략)
            int case1 = d[i - 1];

            // 마지막 두 열을 "가로(1x2 두 장)" 또는 "정사각형(2x2 한 장)"으로 붙이면 → 2 * d[i-2] 가지
            int case2 = d[i - 2] * 2;//경우의 수라서 +2 가 아닌 * 2

            // 둘을 더하면 i를 채우는 총 경우의 수
            d[i] = (case1 + case2) % 796796;
        }

        return d[n];

    }

}
