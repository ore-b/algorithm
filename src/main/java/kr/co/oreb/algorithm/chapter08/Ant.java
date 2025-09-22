package kr.co.oreb.algorithm.chapter08;

public class Ant {

    //foods : 식량 창고들
    public void execute(int n, int[] foods) {

        // d[i] : 0번부터 i번 창고까지 살펴봤을 때
        //        규칙을 지키며 모을 수 있는 "최대 식량"
        int[] d = new int[n];

        d[0] = foods[0];// 처음엔 0번 창고 하나뿐 → 그걸 턴 값
        d[1] = Math.max(foods[0], foods[1]);// 0번/1번 중 더 많은 쪽만 털기

        // 이제 2번 창고부터 끝까지 차례대로 계산
        for (int i = 2; i < n; i++) {

            // i번 창고를 "안 턴다"면: 바로 전까지의 최고 값
            int dontPick = d[i - 1];
            // i번 창고를 "턴다"면: i-2까지 최고 값 + i번 식량
            int pick = d[i - 2] + foods[i];

            // 둘 중 더 큰 걸 선택!
            d[i] = Math.max(dontPick, pick);
        }

        //최대 털수 있는 식량 갯수
        System.out.println(d[n - 1]);
    }

}
