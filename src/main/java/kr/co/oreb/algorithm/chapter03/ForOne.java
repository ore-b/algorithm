package kr.co.oreb.algorithm.chapter03;

public class ForOne {

    public void execute(int n, int k) {

        int hit = 0;

        while (1 < n) {
            if (n % k == 0) {
                n = n / k;
                hit++;
            } else {
                n--;
                hit++;
            }
        }

        System.out.println(hit);
    }

    public void execute2(int n, int k) {

        int hit = 0;

        while (1 < n) {

            if (n < k) {
                //n 이 k 보다 작아서 나눌 수 없는 경우
                hit = hit + (n - 1);
                break;
            }

            //한번에 나눠지는 수까지 빼기
            int target = (n / k) * k;

            //-1 횟수 처리
            hit = hit + (n - target);

            //target 으로 한번에
            n = target;

            n = n / k;
            hit++;//나눈 횟수

        }

        System.out.println(hit);
    }

}
