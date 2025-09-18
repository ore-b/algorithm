package kr.co.oreb.algorithm.chapter03;

public class ChangeCoin {

    public static void main(String[] args) {

        int changeMoney = 1000;

        int[] coins = {500, 100, 50, 10};

        int count = 0;

        for (int coin : coins) {

            int n = changeMoney / coin;

            count += n;

            changeMoney %= coin;

            if (changeMoney <= 0) {
                break;
            }

        }

        System.out.println(count);


    }

}
